package com.example.reactive.section_2.client;

import com.example.reactive.common.AbstractHttpClient;
import reactor.core.publisher.Mono;

public class ExternalHttpClient extends AbstractHttpClient {


    public Mono<String> getProductName(int productId){
        return this
                .httpClient
                .get()
                .uri("/demo01/product/" + productId)
                .responseContent()
                .asString()
                .next();
    }
}
