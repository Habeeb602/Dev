package com.example.reactive.section_4;

import com.example.reactive.common.Util;
import com.example.reactive.section_1.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class FluxSinkDefaultBehaviour {

    private static final Logger log = LoggerFactory.getLogger(FluxSinkDefaultBehaviour.class);

    public static void main(String[] args) {

        var subscriber = new SubscriberImpl();


        /**
         * Flux create() method will produce the elements upfront
         * it will get stored in a queue - size of Integer.MAX_VALUE
         * once the subscriber started requesting items, it will get consumed by the queue
         * this is the default behaviour of flux create() method.
         */
        Flux.<String>create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                var name = Util.getFaker().name().fullName();
                log.info("generated: {}", name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(subscriber);



        Util.sleep(2);
        subscriber.getSubscription().request(Long.MAX_VALUE);
//        Util.sleep(2);
//        subscriber.getSubscription().request(2);
//        Util.sleep(2);
//        subscriber.getSubscription().request(2);
//        Util.sleep(2);
//        subscriber.getSubscription().request(2);
//        Util.sleep(2);
//        subscriber.getSubscription().request(2);
//        Util.sleep(2);
//        subscriber.getSubscription().cancel();



    }
}
