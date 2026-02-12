package com.example.reactive.section_2;

import com.example.reactive.common.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyError {

    public static void main(String[] args) {

        getUserName(1).subscribe(Util.subscriber("Sub1"));
        getUserName(2).subscribe(Util.subscriber("Sub2"));
        getUserName(3).subscribe(Util.subscriber("Sub3"));
    }


    private static Mono<String> getUserName(int userId){
        return switch (userId){
            case 1 -> Mono.just("Sam");
            case 2 -> Mono.empty();
            default -> Mono.error(new IllegalStateException("Unexpected value: " + userId));
        };
    }
}
