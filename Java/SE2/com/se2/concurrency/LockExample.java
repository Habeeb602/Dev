package com.se2.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    private static int count = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        LockExample lockExample = new LockExample();
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> lockExample.criticalSectionLock()).start();
//        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> lockExample.criticalSectionWithTryLock()).start();
        }
    }

    private void criticalSectionLock(){

        try{
            lock.lock();
            int c = count;
            System.out.println("Before Increment: " + count + ", Thread ID: " + Thread.currentThread().getId());
            count = c + 1;
            System.out.println("After Increment: " + count + ", Thread ID: " + Thread.currentThread().getId());
        }
        finally {
            lock.unlock();
        }
    }

    private void criticalSectionWithTryLock(){

        if(lock.tryLock()){
            int c = count;
            System.out.println("Before Increment: " + count + ", Thread ID: " + Thread.currentThread().getId());
            count = c + 1;
            System.out.println("After Increment: " + count + ", Thread ID: " + Thread.currentThread().getId());
        }
        else{
            /**
             * Non-blocking - means, If the critical section code is blocked by some thread
             * The other threads can do something else, instead of waiting for lock release*/
            System.out.println("Do Something else! Thread ID: " + Thread.currentThread().getId());
        }
    }
}
