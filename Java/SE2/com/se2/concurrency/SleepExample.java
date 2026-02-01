package com.se2.concurrency;

public class SleepExample {

    public static void main(String[] args) {

        System.out.println("Countdown started");

        Thread timer = new Thread(new Timer());
        timer.start();

        try{
            /**
             * This joins the thread into main thread, so the main thread executes after
             * completing the timer thread.
            * */
            timer.join();
        }
        catch(InterruptedException ie){
            System.out.println(ie);
        }

        System.out.println("Boom!");
    }
}


class Timer implements Runnable{

    @Override
    public void run(){
        String[] numbers = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        for(int i=numbers.length-1;i>=0;i--){
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException ie){
                System.out.println(ie);
            }
            System.out.println(numbers[i]);
        }
    }
}
