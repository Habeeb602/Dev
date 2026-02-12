package com.example.reactive.section_4;

import com.example.reactive.common.Util;
import com.example.reactive.section_4.Util.NameGenerator;
import reactor.core.publisher.Flux;

public class FluxCreateRefactored {

    public static void main(String[] args) {

        var generator = new NameGenerator();
        Flux.create(generator)
                .subscribe(Util.subscriber());

        for (int i = 0; i < 10; i++) {
            generator.generate();
        }
    }

}



