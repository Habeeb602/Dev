package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxFromIterableOrArray {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "Hi", "Welcome");
        Integer[] arr = {1, 2, 3, 4, 5};

        Flux.fromIterable(list)
                .subscribe(Util.subscriber("ListSub"));

        Flux.fromArray(arr)
                .subscribe(Util.subscriber("ArraySub"));
    }
}
