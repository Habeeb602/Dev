package com.se2.concurrency;

public class SynchronizedExample {

    private static int x;
    private static final Object lock = new Object();


    public static void main(String[] args) {

//        for(int i=0;i<10;i++){
//            new Thread(() -> incrementCounter()).start();
//        }

//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> incrementCounterBlock()).start();
//        }

//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> incrementCounterWithLock()).start();
//        }

        SynchronizedExample synchronizedExampleInstance = new SynchronizedExample();

//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> synchronizedExampleInstance.incrementCounterInstance()).start();
//        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> synchronizedExampleInstance.incrementCounterInstanceBlock()).start();
        }
    }

    // 1.1)
    private static synchronized void incrementCounter(){
        System.out.println("Before Increment: " + x + ", Thread ID: " + Thread.currentThread().getId());
        x++;
        System.out.println("After Increment: " + x + ", Thread ID: " + Thread.currentThread().getId());
    }

    // 1.2)
    private static void incrementCounterBlock(){
        synchronized (SynchronizedExample.class){
            System.out.println("Before Increment: " + x + ", Thread ID: " + Thread.currentThread().getId());
            x++;
            System.out.println("After Increment: " + x + ", Thread ID: " + Thread.currentThread().getId());
        }
    }

    // 2.1)
    private synchronized void incrementCounterInstance(){
        System.out.println("Before Increment: " + x + ", Thread ID: " + Thread.currentThread().getId());
        x++;
        System.out.println("After Increment: " + x + ", Thread ID: " + Thread.currentThread().getId());
    }

    // 2.2)
    private void incrementCounterInstanceBlock(){

        synchronized (this){
            System.out.println("Before Increment: " + x + ", Thread ID: " + Thread.currentThread().getId());
            x++;
            System.out.println("After Increment: " + x + ", Thread ID: " + Thread.currentThread().getId());
        }
    }


    // 3)
    private static void incrementCounterWithLock(){
        /**
         * Every Java object has a lock-release attribute with it.
         * it can be used to manage the lock for critical section code
         * */
        /**
         * Every Thread, that is trying to access this code block, will check whether it's locked
         * If so, it will wait until the lock is released
         * If not, it will acquire the lock and execute the code
         * And when leaving, it will release the lock.
         * */
        synchronized (lock){
            System.out.println("Before Increment: " + x + ", Thread ID: " + Thread.currentThread().getId());
            x++;
            System.out.println("After Increment: " + x + ", Thread ID: " + Thread.currentThread().getId());
        }
    }

}
