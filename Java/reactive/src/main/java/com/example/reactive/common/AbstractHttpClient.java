package com.example.reactive.common;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.LoopResources;



public abstract class AbstractHttpClient {

    private static final String BASE_URL = "http://localhost:7070";
    protected final HttpClient httpClient;

    public AbstractHttpClient(){
        LoopResources lp = LoopResources.create("event-loop", 1, true);
        httpClient = HttpClient.create().runOn(lp).baseUrl(BASE_URL);
    }
}
