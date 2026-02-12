package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.IntStream;

public class ListVsFlux {

    private static final Logger log = LoggerFactory.getLogger(ListVsFlux.class);

    private static List<String> generateNames(int count){
        return IntStream
                .rangeClosed(1, count)
                .mapToObj(i -> getName())
                .toList();
    }

    private static Flux<String> generateNamesFlux(int count){
        // sleep used to emulate process-intensive method call
        return Flux
                .range(1, count)
                .map(i -> getName());
    }

    private static String getName(){
        // sleep used to emulate process-intensive method call
        Util.sleep(1);
        return Util.getFaker().name().fullName();
    }


    public static void main(String[] args) {

//        System.out.println(generateNames(10));

        generateNamesFlux(10)
                .subscribe(Util.subscriber());
    }

}
