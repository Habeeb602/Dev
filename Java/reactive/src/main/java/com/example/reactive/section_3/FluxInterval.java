package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxInterval {

    public static void main(String[] args) {


        Flux
                .interval(Duration.ofMillis(500))
                .subscribe(Util.subscriber("Sub-1"));

        Util.sleep(10);
    }

}
