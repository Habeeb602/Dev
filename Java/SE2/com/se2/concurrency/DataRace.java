package com.se2.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class DataRace {

    private static int count = 0;

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void addToCounter(){
        int c = count;
        System.out.println("Before: count = " + count + ", Thread ID: " + Thread.currentThread().getId());
        count = c + 1;
        System.out.println("After: count = " + count + ", Thread ID: " + Thread.currentThread().getId());
    }


    private static void atomicIntegerCounter(){
        System.out.println("Before: count = " + atomicInteger.get() + ", Thread ID: " + Thread.currentThread().getId());
        atomicInteger.getAndIncrement();
        System.out.println("After: count = " + atomicInteger.get() + ", Thread ID: " + Thread.currentThread().getId());
    }



    public static void main(String[] args) {

//        for(int i=0;i<10;i++){
//            new Thread(() -> addToCounter()).start();
//        }

        for(int i=0;i<10;i++){
            new Thread(DataRace::atomicIntegerCounter).start();
        }


    }
}
