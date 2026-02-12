package com.example.reactive.section_2;

import com.example.reactive.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class MonoFromCallable {

    private static final Logger log = LoggerFactory.getLogger(MonoFromCallable.class);

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);


        // here 'just' shouldn't be used, because this has no subscribers.
        // we want to be as lazy as possible
        var mono = Mono.just(sum(list));


        // fromCallable is a lazy operation. until a subscriber subscribes it will not process the supplied data
        mono = Mono.fromCallable(() -> sum(list));


        // example with subscriber
        mono = Mono.fromCallable(() -> sum(list));
        mono.subscribe(Util.subscriber());
    }


    public static int sum(List<Integer> list){
        log.info("Finding the sum of {}", list);
        return list.stream().reduce(0, Integer::sum);
    }

}
