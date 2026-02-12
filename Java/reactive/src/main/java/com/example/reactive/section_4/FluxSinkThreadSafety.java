package com.example.reactive.section_4;

import com.example.reactive.common.Util;
import com.example.reactive.section_4.Util.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class FluxSinkThreadSafety {

    private static final Logger log = LoggerFactory.getLogger(FluxSinkThreadSafety.class);

    public static void main(String[] args) {

//        nonThreadSafeDemo();
        threadSafeDemo();

    }

    private static void nonThreadSafeDemo(){
        var list = new ArrayList<>();

        Runnable thousandItems = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(thousandItems);
        }


        Util.sleep(20);
        log.info("Number of items added in the list is {}", list.size());

    }

    private static void threadSafeDemo(){
        var list = new ArrayList<>();

        var nameGenerator = new NameGenerator();
        Flux.create(nameGenerator)
                .subscribe(list::add);

        Runnable thousandItems = () -> {
            for (int i = 0; i < 1000; i++) {
                nameGenerator.generate();
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(thousandItems);
        }


        Util.sleep(2);
        log.info("Number of items added in the list is {}", list.size());

    }
}
