// MinimalMessageQueue.java
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class MinimalMessageQueue {
    static class Message {
        final long offset;
        final String id;
        final byte[] payload;
        final long ts;

        Message(long offset, String id, byte[] payload, long ts) {
            this.offset = offset;
            this.id = id;
            this.payload = payload;
            this.ts = ts;
        }
    }

    private final Path logFile;
    private final RandomAccessFile raf;
    private final FileChannel channel;
    private final AtomicLong nextOffset = new AtomicLong(0);
    private final BlockingQueue<Message> inMemoryQueue = new LinkedBlockingQueue<>();
    private final ConcurrentMap<Long, InFlight> inflight = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final long visibilityMs;
    private final ExecutorService writer = Executors.newSingleThreadExecutor();

    static class InFlight {
        final Message msg;
        final long deadline;
        InFlight(Message msg, long deadline) { this.msg = msg; this.deadline = deadline; }
    }

    public MinimalMessageQueue(Path path, long visibilityMs) throws IOException {
        this.logFile = path;
        Files.createDirectories(path.getParent());
        this.raf = new RandomAccessFile(logFile.toFile(), "rw");
        this.channel = raf.getChannel();
        this.visibilityMs = visibilityMs;

        // recover offsets by reading file size / simple scan (for demo only)
        long filePos = channel.size();
        // Next offset will be filePos / recordSize? For simplicity, we keep an atomic counter persisted
        nextOffset.set(0);

        // Start background re-delivery scanner
        scheduler.scheduleAtFixedRate(this::scanExpired, visibilityMs/2, visibilityMs/2, TimeUnit.MILLISECONDS);
    }

    // producer API
    public CompletableFuture<Long> enqueueAsync(byte[] payload) {
        CompletableFuture<Long> fut = new CompletableFuture<>();
        writer.submit(() -> {
            try {
                long offset = nextOffset.getAndIncrement();
                String id = UUID.randomUUID().toString();
                // Simple record layout: [offset(long)][idLen(int)][id(bytes)][payloadLen(int)][payload(bytes)]
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bout);
                dos.writeLong(offset);
                dos.writeInt(id.length());
                dos.writeBytes(id);
                dos.writeInt(payload.length);
                dos.write(payload);
                byte[] record = bout.toByteArray();
                synchronized(channel) {
                    channel.position(channel.size());
                    channel.write(ByteBuffer.wrap(record));
                    channel.force(true); // fsync - configurable in real system
                }
                Message m = new Message(offset, id, payload, Instant.now().toEpochMilli());
                inMemoryQueue.offer(m);
                fut.complete(offset);
            } catch (Exception e) {
                fut.completeExceptionally(e);
            }
        });
        return fut;
    }

    // consumer API - poll a message (blocking)
    public Message poll() throws InterruptedException {
        Message m = inMemoryQueue.poll(5, TimeUnit.SECONDS);
        if (m == null) return null;
        long deadline = System.currentTimeMillis() + visibilityMs;
        inflight.put(m.offset, new InFlight(m, deadline));
        return m;
    }

    // ack
    public boolean ack(long offset) {
        InFlight r = inflight.remove(offset);
        // In a real system, track committed offsets persistently per consumer group
        return r != null;
    }

    // re-deliver expired messages
    private void scanExpired() {
        long now = System.currentTimeMillis();
        for (Map.Entry<Long, InFlight> e : inflight.entrySet()) {
            if (e.getValue().deadline <= now) {
                // redeliver
                inflight.remove(e.getKey());
                inMemoryQueue.offer(e.getValue().msg);
            }
        }
    }

    public void close() throws IOException {
        scheduler.shutdownNow();
        writer.shutdownNow();
        channel.close();
        raf.close();
    }

    // For demo / quick test
    public static void main(String[] args) throws Exception {
        Path p = Paths.get("data/queue.log");
        MinimalMessageQueue q = new MinimalMessageQueue(p, 5000); // 5s visibility
        // Producer
        for (int i=0;i<10;i++) {
            String txt = "msg-" + i;
            q.enqueueAsync(txt.getBytes()).thenAccept(off -> System.out.println("enqueued " + off));
        }

        // Consumer
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                while (true) {
                    Message m = q.poll();
                    if (m == null) continue;
                    System.out.println("got " + new String(m.payload) + " offset=" + m.offset);
                    // simulate processing failure for some messages to see retry
                    if (m.offset % 3 == 0) {
                        System.out.println("simulate fail for " + m.offset + " (no ack)");
                    } else {
                        q.ack(m.offset);
                        System.out.println("acked " + m.offset);
                    }
                }
            } catch (InterruptedException e) { }
        });

        Thread.sleep(20000);
        q.close();
    }
}
