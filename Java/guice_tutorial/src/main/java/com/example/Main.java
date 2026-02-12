package com.example;

import com.example.module.AppModule;
import com.example.request.SquareRequest;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        guiceDI();
    }

    private static void manualDI(){
//        DrawShape drawShape = new DrawSquare();
//        SquareRequest sq = new SquareRequest(drawShape);
//        sq.makeRequest();
    }

    private static void guiceDI(){
        Injector injector = Guice.createInjector(new AppModule());
        SquareRequest sq1 = injector.getInstance(SquareRequest.class);
        sq1.makeRequest();

        SquareRequest sq2 = injector.getInstance(SquareRequest.class);
        sq2.makeRequest();


        System.out.println("----- Singleton Tests -----");
        System.out.printf("sq1.drawShape == sq2.drawShape ? %s\n", sq1.drawShape == sq2.drawShape);
        System.out.printf("sq1 == sq2 ? %s\n", sq1 == sq2);
    }
}