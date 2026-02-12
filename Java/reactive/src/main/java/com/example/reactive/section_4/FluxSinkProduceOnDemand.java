package com.example.reactive.section_4;

import com.example.reactive.common.Util;
import com.example.reactive.section_1.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class FluxSinkProduceOnDemand {

    private static final Logger log = LoggerFactory.getLogger(FluxSinkProduceOnDemand.class);

    public static void main(String[] args) {


        var subscriber = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {


            fluxSink.onRequest(request -> {
                String name;
                for (int i = 0; i < request && !fluxSink.isCancelled(); i++) {
                    name = Util.getFaker().funnyName().name();
                    log.info("Generated: {}", name);
                    fluxSink.next(name);
                }
            });

        }).subscribe(subscriber);


        subscriber.getSubscription().request(2);
        Util.sleep(1);
        subscriber.getSubscription().request(2);
        Util.sleep(1);
        subscriber.getSubscription().request(2);
        Util.sleep(1);
        subscriber.getSubscription().request(2);
        Util.sleep(1);
        subscriber.getSubscription().cancel();
    }
}
