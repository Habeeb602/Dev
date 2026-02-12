package com.example.reactive.section_2;

import com.example.reactive.section_1.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoJust {

    private static final Logger log = LoggerFactory.getLogger(MonoJust.class);

    public static void main(String[] args) {

        example2();

    }

    // mono with subscriber & subscription
    private static void example1(){
        var mono = Mono.just("Hi");
        SubscriberImpl subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(10);
    }


    // mono subscribe example
    private static void example2(){
        var mono = Mono.just("Hello");

        // with just a consumer
        mono.subscribe(
                msg -> log.info("Received: {}", msg)
        );

        mono = Mono.just("Good Morning!!!");


        // with consumer, error handler, on complete, & subscription cancel
        mono.subscribe(
                msg -> log.info("Received 'Consumer': {}", msg),
                err -> log.error("Error: {}", err.getMessage()),
                () -> log.info("Completed 1"),
                subscription -> subscription.cancel()
        );


        // with consumer, error handler, on complete, & subscription request
        mono.subscribe(
                msg -> log.info("Received 'Consumer': {}", msg),
                err -> log.error("Error: {}", err.getMessage()),
                () -> log.info("Completed 2"),
                subscription -> subscription.request(10)
        );




        var intMono = Mono.just(1)
                .map(msg -> msg / 0);

        // testing on error
        intMono.subscribe(
                msg -> log.info("Received 'Consumer': {}", msg),
                err -> log.error("Error: {}", err.getMessage()),
                () -> log.info("Completed 3"),
                subscription -> subscription.request(10)
        );
    }

}
