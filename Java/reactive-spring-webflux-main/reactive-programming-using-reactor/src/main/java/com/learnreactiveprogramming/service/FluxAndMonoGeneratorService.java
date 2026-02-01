package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> namesFlux(){
        return Flux.fromIterable(List.of("apple", "banana", "cranberry")).log();
    }

    public Mono<String> namesMono(){
        return Mono.just("apple").log();
    }

    public Flux<String> fluxMap(){
        return Flux.fromIterable(List.of("apple", "banana", "cranberry"))
                .map(String::toUpperCase)
                .log();
    }


    public Flux<String> fluxImmutabilityTest(){
        Flux<String> res = Flux.fromIterable(List.of("apple", "banana", "cranberry")).log();
        res.map(fruit -> {
            String upperCaseFruit = fruit.toUpperCase();
            System.out.println(upperCaseFruit);
            return upperCaseFruit;
        }).log();

        return res;
    }

    public Flux<String> fluxFilterAndMap(int len){

        List<String> list = List.of("apple", "banana", "cranberry");
        return Flux.fromIterable(list)
                .filter(s -> s.length() > len)
                .map(String::toUpperCase)
                .map(s -> s.length() + "-" + s)
                .log();
    }

    public Flux<String> splitString(String s){
        return Flux.fromArray(s.split(""));
    }

    public Flux<String> fluxFlatMap(){
        List<String> list = Arrays.asList("apple", "banana", "cranberry");

        return
                Flux.fromIterable(list)
                    .map(String::toUpperCase)
                    .flatMap(this::splitString)
                    .log();

    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();

        service
            .namesFlux()
            .subscribe(name -> {
                System.out.println("Flux-Fruit name is " + name);
            });

        service
            .namesMono()
            .subscribe(name -> {
                System.out.println("Mono-Fruit name is " + name);
            });
    }
}
