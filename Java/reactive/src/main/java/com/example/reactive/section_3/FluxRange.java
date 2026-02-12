package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class FluxRange {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .subscribe(Util.subscriber("Range counting 1 .. 10"));


        Flux.range(1, 15)
                .map(i -> Util.getFaker().animal().name())
                .subscribe(Util.subscriber("Animal name"));
    }
}
