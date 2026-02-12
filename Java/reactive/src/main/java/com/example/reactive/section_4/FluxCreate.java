package com.example.reactive.section_4;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class FluxCreate {

    public static void main(String[] args) {

        /**
         * simple fluxSink with flux create
         */
        Flux.create(fluxSink -> {
            fluxSink.next(1);
            fluxSink.next(2);
            fluxSink.next(3);
            fluxSink.complete();
        })
                .subscribe(Util.subscriber("num-sub"));


        Flux.create(fluxSink -> {
            String country;
            do{
                country = Util.getFaker().country().name();
                fluxSink.next(country);
            }while(!country.equalsIgnoreCase("sudan"));
            fluxSink.complete();
        })
                .subscribe(Util.subscriber("country-sub"));
    }
}
