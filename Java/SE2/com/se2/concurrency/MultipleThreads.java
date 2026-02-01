package com.se2.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultipleThreads {

    static List<Callable<String>> callables = new ArrayList<>();

//    static ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

    static ExecutorService fixedMultiThreadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {

        callables.add(() -> "A");
        callables.add(() -> "B");
        callables.add(() -> "C");
        callables.add(() -> "D");

        /** Single Thread executor invokeAny*/
//        invokeAny(1);

        /** Multi Thread executor invokeAny*/
        invokeAny(2);

        /** Multi Thread executor invokeAll*/
        invokeAll();

//        singleThreadPool.shutdown();
        fixedMultiThreadPool.shutdown();
    }

    private static void invokeAny(int c){
        String result;
        try{
            if(c == 1){
//                result = singleThreadPool.invokeAny(callables);
//                System.out.println("result (Single Thread invokeAny()) = " + result);
            }
            else{
                result = fixedMultiThreadPool.invokeAny(callables);
                System.out.println("result (Multi Thread invokeAny()) = " + result);
            }
        }
        catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        System.out.println("invokeAny() ends");
    }

    private static void invokeAll(){
        try{
            List<Future<String>> futures = fixedMultiThreadPool
                    .invokeAll(callables);

            for(Future<String> stringFuture: futures){
                System.out.println(stringFuture.get());
            }
        }
        catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        System.out.println("invokeAll() ends");
    }


}

