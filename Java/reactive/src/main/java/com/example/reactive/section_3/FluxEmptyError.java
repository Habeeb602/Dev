package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

public class FluxEmptyError {

    public static void main(String[] args) {

        Flux.empty()
                .subscribe(Util.subscriber());

        Flux.error(() -> new RuntimeException("Something went wrong"))
                .subscribe(Util.subscriber());
    }
}
