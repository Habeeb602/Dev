package com.example.reactive.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber<T> {

    private static final Logger log = LoggerFactory.getLogger(DefaultSubscriber.class);
    private Subscription subscription;
    private final String name;

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(Long.MAX_VALUE);
    }
    @Override
    public void onNext(T t) {
        log.info("{} received {}", name, t);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("{} error {}", name, throwable.getMessage());
    }

    @Override
    public void onComplete() {
        log.info("{} completed", name);
    }
}
