package com.se2.concurrency;

public class ThreadExample {


    public static void main(String[] args) {

        new NewThread().start();
        new Thread(new ThreadRunnable()).start();

        /** Using Lambda as Runnable.
         * Runnable interface is a functional interface
         * It can be implemented through lambda
         * */
        new Thread(() -> System.out.println("Lambda Runnable implementation: " + Thread.currentThread().getName())).start();
        System.out.println("main(): " + Thread.currentThread().getName());

        /**
         * If we use run() to invoke the thread, it just invokes the function, in the main() thread
         * As it won't create a new thread*/
        new NewThread().run();




    }
}


class NewThread extends Thread{
    @Override
    public void run(){
        System.out.println("run() - Thread Extended: " + getName());
    }
}

class ThreadRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("run() - Thread Runnable: " + Thread.currentThread().getName());
    }
}