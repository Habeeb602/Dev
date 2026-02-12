package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import com.example.reactive.section_3.client.ExternalHttpClient;

public class NonBlockingIOWithFlux {

    public static void main(String[] args) {
        var client = new ExternalHttpClient();

        client.getNames()
                .subscribe(Util.subscriber("Sub-1"));

        client.getNames()
                .subscribe(Util.subscriber("Sub-2"));


        Util.sleep(6);
    }
}
