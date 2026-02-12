package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class LogOperator {

    public static void main(String[] args) {


        /**
         * Log implements both Publisher & Subscriber.
         *
         * In our day-to-day code, the code gives us the value is a publisher (upper one)
         * The code below, the one it takes the value is a subscriber
         * we can give a specific name to log method to trace the logs properly
         */

        Flux.range(1, 5)
                .log("range-map")
                .map(i -> Util.getFaker().backToTheFuture().character())
                .log("map-subscriber")
                .subscribe(Util.subscriber());

    }
}
