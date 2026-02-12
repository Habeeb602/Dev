package com.example.reactive.common;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Util {
    private static final Faker faker = Faker.instance();

    public static <T> DefaultSubscriber<T> subscriber(){
        return new DefaultSubscriber<T>("Default");
    }

    public static <T> DefaultSubscriber<T> subscriber(String name){
        return new DefaultSubscriber<T>(name);
    }

    public static Faker getFaker(){
        return faker;
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        var mono = Mono.just("Hello");

        mono.subscribe(subscriber());
        mono.subscribe(subscriber("sub1"));
        mono.subscribe(subscriber("sub2"));
    }

}
