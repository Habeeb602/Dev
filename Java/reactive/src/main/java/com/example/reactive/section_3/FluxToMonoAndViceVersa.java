package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxToMonoAndViceVersa {

    public static void main(String[] args) {


        // Mono  --> Flux
        Mono<String> mono = getName(1);
        Flux<String> flux = Flux.from(mono);
        save(flux);


        // Flux to Mono
        Flux<Integer> flux1 = Flux.range(1, 10);
        Mono<Integer> mono1 = Mono.from(flux1);
        save(mono1);


    }

    private static void save(Mono<Integer> names){
        names
                .subscribe(Util.subscriber());
    }


    private static void save(Flux<String> names){
        names
                .subscribe(Util.subscriber());
    }


    private static Mono<String> getName(int id){
        return switch (id){
            case 1 -> Mono.just("Carl");
            case 2 -> Mono.just("Unknown");
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }
}
