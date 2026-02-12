package com.example.reactive.section_3.Util;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockSubscriber<T> implements Subscriber<T> {

    private static final Logger log = LoggerFactory.getLogger(StockSubscriber.class);
    private Subscription subscription;
    private final double INITIAL = 1000;
    private double balance = INITIAL;
    private int stockCount = 0;


    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
        log.info("---------------------------------------------------");
        int price = (int)t;
        log.info("Latest stock price: {}", t);
        boolean transaction = false;

        if(price >= 115 && stockCount > 0){
            log.info("Selling all the stocks for ${}", t);
            double sold = price * stockCount;
            stockCount = 0;
            balance += sold;
            transaction = true;
        }

        if(price <= 85 && balance >= price){
            int stocksBought = (int) (balance / price);
            balance -= stocksBought * price;
            log.info("{} stocks bought", stocksBought);
            stockCount = stocksBought;
            transaction = true;
        }


        if(transaction){
            log.info("Current balance after transaction: {}", balance);
            log.info("Stock count after transaction: {}", stockCount);
        }
        else{
            log.info("Current balance without any transaction: {}", balance);
            log.info("Stock count without any transaction: {}", stockCount);
        }

        log.info("---------------------------------------------------");
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("Received Error {}", throwable.getMessage());
        throw new RuntimeException(throwable);
    }

    @Override
    public void onComplete() {
        log.info("Completed with balance ${} and made profit of ${}", balance, balance-INITIAL);
    }
}
