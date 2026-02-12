package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class FluxJust {

    public static void main(String[] args) {

        var flux = Flux.just("Hello", 1, 2, 3, "Hi", 3.5, 'b', true);

        flux.subscribe(Util.subscriber("FluxSub"));
    }
}
