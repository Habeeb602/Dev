package com.example.reactive.section_2;

import com.example.reactive.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class MonoDefer {

    private static final Logger log = LoggerFactory.getLogger(MonoDefer.class);

    public static void main(String[] args) {

//        createPublisher()
//                .subscribe(Util.subscriber("Sub1"));

        /**
         * Usually the creation of a publisher is a light-weight task.
         * But if we want that to make it lazy, we can use defer method.
         */


        Mono.defer(() -> createPublisher())
                .subscribe(Util.subscriber("Sub1"));
    }


    private static Mono<Integer> createPublisher(){
        log.info("creating publisher");
        List<Integer> list = Arrays.asList(1,2,3);
        Util.sleep(2);

        return Mono.fromSupplier(() -> calculate(list));
    }

    private static int calculate(List<Integer> list){
        log.info("computing sum of {}", list);
        Util.sleep(5);
        return list.stream().mapToInt(k -> k).sum();
    }

}
