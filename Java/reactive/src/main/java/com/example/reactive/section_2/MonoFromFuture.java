package com.example.reactive.section_2;

import com.example.reactive.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {

    private static final Logger log = LoggerFactory.getLogger(MonoFromFuture.class);



    public static void main(String[] args) {


        /**
         * Problem: passing CompletableFuture in fromFuture() works eagerly
         */
//        Mono.fromFuture(getName());
//                .subscribe(Util.subscriber());

        /**
         * Fix: pass it as a supplier.
         */

        Mono.fromFuture(() -> getName())
                        .subscribe(Util.subscriber());

        Util.sleep(1);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> {
            log.info("generating name...");
            return Util.getFaker().superhero().name();
        });
    }
}
