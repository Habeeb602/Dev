package com.example.reactive.section_1.publisher;

import com.example.reactive.section_1.subscriber.SubscriberImpl;
import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private final Logger log = LoggerFactory.getLogger(SubscriberImpl.class);
    private Subscriber<? super String> subscriber;
    private boolean isCancelled = false;
    private final int MAX_ITEMS = 10;
    private int count;
    private final Faker faker;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        faker = Faker.instance();
        count = 0;
    }

    @Override
    public void request(long requested) {

        if(!isCancelled){
            log.info("Subscriber requested {} items", requested);

            for (int i = 0; i < requested && count < MAX_ITEMS; i++) {
                subscriber.onNext(faker.internet().emailAddress());
                count++;
            }

            if(count == MAX_ITEMS){
                log.info("No more items in the publisher");
                subscriber.onComplete();
            }
        }

    }

    @Override
    public void cancel() {
        if(!isCancelled){
            log.info("Subscription Cancelled!!!");
            isCancelled = true;
        }
    }
}
