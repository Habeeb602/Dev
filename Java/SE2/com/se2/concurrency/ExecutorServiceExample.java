package com.se2.concurrency;

import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {

        ExecutorServiceExample ese = new ExecutorServiceExample();
        ese.runnable();
        ese.callable();

    }


    public void runnable(){

        ExecutorService es = Executors.newSingleThreadExecutor();

        // Assigning runnable to the thread executor
        es.execute(() -> System.out.println("Single Thread Executor - Runnable"));

        // It will shut down the ExecutorService, i.e. it will no longer accept any threads to be executed
        // But it will run all the threads added before this shutdown method call.
        es.shutdown();
    }

    public void callable(){

        ExecutorService es = Executors.newSingleThreadExecutor();

        Future<Integer> future = es.submit(() -> 3 + 9);

        System.out.println("future.isDone() = " + future.isDone());

        try{
            /** This future.get() is a blocking code, means it wait for 500 ms
             *  And executes the code and continues the main thread
              */
            System.out.println("The thread result is "  + future.get(500, TimeUnit.MILLISECONDS));
        }
        catch (InterruptedException | TimeoutException | ExecutionException e){
            System.out.println("Exception = " + e);
        }

        es.shutdown();
    }
}
