package com.se2.concurrency;

import java.util.concurrent.*;

public class ScheduledExecutorExample {

    private static ScheduledExecutorService scheES = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
//        schedule();
//        scheduleWithFixedDelay();
        scheduleAtFixedRate();
    }


    private static void schedule(){

        System.out.println("Normal - Schedule Start...");

        Future<String> future = scheES.schedule(() -> "A", 2, TimeUnit.SECONDS);

        try{
            System.out.println("Normal - future.get() = " + future.get());
        }
        catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        finally {
            scheES.shutdown();
        }

        System.out.println("Normal - Schedule End...");
    }

    private static void scheduleWithFixedDelay(){

        final long INITIAL_DELAY = 2000;
        final long WAIT_PERIOD_AFTER_A_TASK_COMPLETION = 300;
        System.out.println("ScheduleWithFixedDelay - Start...");
        /**
         * It will run the thread forever with the delay period given in.
         * */
        scheES.scheduleWithFixedDelay(
                () -> System.out.println("Thread ID: " + Thread.currentThread().getId()),
                INITIAL_DELAY,
                WAIT_PERIOD_AFTER_A_TASK_COMPLETION,
                TimeUnit.MILLISECONDS);

//        scheES.shutdown();
    }

    private static void scheduleAtFixedRate(){

        final long INITIAL_DELAY = 2000;
        final long WAIT_PERIOD_AFTER_A_TASK_COMPLETION = 300;
        System.out.println("ScheduleWithFixedRate - Start...");


        /**
         * It will run the Thr
         * */
        scheES.scheduleAtFixedRate(
                () -> System.out.println("Thread ID: " + Thread.currentThread().getId()),
                INITIAL_DELAY,
                WAIT_PERIOD_AFTER_A_TASK_COMPLETION,
                TimeUnit.MILLISECONDS);

//        scheES.shutdown();
    }
}
