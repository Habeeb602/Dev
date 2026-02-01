import java.util.*;
import java.util.concurrent.locks.*;

public class CustomBlockingQueueExample{
	public static void main(String[] args){
	
		// CustomBlockingQueue<Integer> q = new CustomBlockingQueue<>(10);
		CustomBlockingQueueWithWaitAndNotify<Integer> q = new CustomBlockingQueueWithWaitAndNotify<>(10);
		
		
		Thread producer1 = new Thread(() -> {
			for(int i=1;i<10;i++){
				System.out.println("Produced from producer1");
				q.producer(i);
				
				try{
					Thread.sleep(1000);
				}
				catch(InterruptedException ex){
					ex.printStackTrace();
				}
			}
		});
		Thread producer2 = new Thread(() -> {
			for(int i=100;i<120;i++){
				q.producer(i);
				
				try{
					Thread.sleep(1000);
				}
				catch(InterruptedException ex){
					ex.printStackTrace();
				}
			}
		});
		
		Thread consumer1 = new Thread(() -> {
			while(true){
				q.consumer();
				System.out.println("Consumed from consumer1");
			}
		});
		
		Thread consumer2 = new Thread(() -> {
			while(true){
				q.consumer();
				System.out.println("Consumed from consumer2");
			}
		});
		
		producer1.start();
		// producer2.start();
		
		consumer1.start();
		consumer2.start();
	}
}


class CustomBlockingQueue<E> {
	private ReentrantLock lock = new ReentrantLock();
	private Queue<E> q;
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	
	private final int MAX_SIZE;
	
	public CustomBlockingQueue(int size){
		this.q = new LinkedList<>();
		this.MAX_SIZE = size;
	}
	
	public void producer(E e){
		lock.lock();
		
		try{
			while(q.size() == MAX_SIZE){
				// notFull.await();
				awaitSafely(notFull);
			}
			System.out.println("Producing " + e + " into the queue");
			q.offer(e);
			notEmpty.signal();
		}
		finally{
			lock.unlock();
		}
	}
	
	public void consumer(){
		lock.lock();
		
		try{
			while(q.size() == 0){
				// notEmpty.await();
				awaitSafely(notEmpty);
			}
			E e = q.poll();
			System.out.println("Consuming " + e + " from the queue");
			notFull.signal();
		}
		finally{
			lock.unlock();
		}
	}
	
	private void awaitSafely(Condition cond){
		try{
			cond.await();
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}





class CustomBlockingQueueWithWaitAndNotify<T>{
	
	private Object notEmpty;
	private Object notFull;
	private Queue<T> queue;
	private final int SIZE;
	
	public CustomBlockingQueueWithWaitAndNotify(int SIZE){
		queue = new LinkedList<>();
		notEmpty = new Object();
		notFull = new Object();
		this.SIZE = SIZE;
	}
	
	
	public void producer(T t){
		
		while(queue.size() == SIZE){
			waitSafely(notFull);
		}
		queue.offer(t);
		notifySafely(notEmpty);
	}
	
	public T consumer(){
		while(queue.size() == 0){
			waitSafely(notEmpty);
		}
		T t = queue.poll();
		notifySafely(notFull);
		return t;
	}
	
	private void notifySafely(Object obj){
		
		synchronized(obj){
			
			obj.notify();
		}
		
	}
	
	private void waitSafely(Object obj){
		
		synchronized(obj){
			try{
				obj.wait();
			}
			catch(InterruptedException ex){
				ex.printStackTrace();
			}			
		}
		
	}
}