package com.example.reactive.section_2;

import com.example.reactive.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    private static final Logger log = LoggerFactory.getLogger(MonoFromRunnable.class);
    /**
     * fromRunnable() used in the case, when we want to do some operation before emitting either value or empty
     */

    public static void main(String[] args) {

        // Available product
        getProductName(1).subscribe(Util.subscriber("Sub1"));

        // Unavailable product
        getProductName(2).subscribe((Util.subscriber("Sub2")));
    }


    private static Mono<String> getProductName(int productId){
        if(productId == 1){
            return Mono.fromSupplier(() -> Util.getFaker().commerce().productName());
        }

        return Mono.fromRunnable(() -> notify(productId));
    }

    private static void notify(int productId){
        log.info("Customer requested product {} currently not available or out-of-stock", productId);
    }
}
