package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();

    @Test
    public void testService(){

        StepVerifier.create(service.namesFlux())
//                .expectNext("apple", "banana", "cranberry")
                .expectNextCount(3)
                .verifyComplete();

        StepVerifier.create(service.namesMono())
                .expectNextCount(1)
                .verifyComplete();


    }

    @Test
    public void fluxMap() {
        List<String> list = List.of("APPLE", "BANANA", "CRANBERRY");

        StepVerifier.create(service.fluxMap())
                .expectNextSequence(list)
                .verifyComplete();
    }

    @Test
    public void testFluxMapImmutability(){
        List<String> list = List.of("apple", "banana", "cranberry");
        StepVerifier.create(service.fluxImmutabilityTest())
                .expectNextSequence(list)
                .verifyComplete();
    }

    @Test
    void fluxFilterAndMap() {

        List<String> list = List.of("6-BANANA", "9-CRANBERRY");

        StepVerifier.create(service.fluxFilterAndMap(5))
                .expectNextSequence(list)
                .verifyComplete();
    }

    @Test
    void fluxFlatMap(){
        String[] res = new String[]{"A","P","P","L","E","B","A","N","A","N","A","C","R","A","N","B","E","R","R","Y"};

        StepVerifier
                .create(service.fluxFlatMap())
                .expectNext(res)
                .verifyComplete();
    }
}