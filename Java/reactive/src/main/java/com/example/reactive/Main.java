package com.example.reactive;

import com.example.reactive.section_1.publisher.PublisherImpl;
import com.example.reactive.section_1.subscriber.SubscriberImpl;
import org.reactivestreams.Subscription;

public class Main {

    public static void main(String[] args) {
            demo();
    }

    private static void demo() {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        Subscription subscription = subscriber.getSubscription();
        try {
            subscription.request(3);
            Thread.sleep(2000);
            subscription.request(3);
            Thread.sleep(2000);
            subscription.request(3);
            Thread.sleep(2000);
            subscription.request(3);
            Thread.sleep(2000);
        }
        catch (InterruptedException ignored){}
        subscription.request(3);
    }
}
