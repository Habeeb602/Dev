package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxFromStream {

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        /**
         * stream can be consumed at max once.
         * if we try to use the consumed stream again, it will throw an error.
         */


        Flux.fromStream(list::stream)
                .subscribe(Util.subscriber("sub-1"));

        Flux.fromStream(list::stream)
                .subscribe(Util.subscriber("sub-2"));
    }
}
