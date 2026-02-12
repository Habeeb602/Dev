package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class FluxWithMulSub {


    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6, 7, 8);

        flux.subscribe(Util.subscriber("FullSubscriber"));

        flux.
                filter(x -> x % 2 == 0)
                .subscribe(Util.subscriber("EvenSubscriber"));
    }

}
