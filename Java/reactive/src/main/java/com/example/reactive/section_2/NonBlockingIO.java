package com.example.reactive.section_2;

import com.example.reactive.common.Util;
import com.example.reactive.section_2.client.ExternalHttpClient;

public class NonBlockingIO {

    public static void main(String[] args) {
        var client = new ExternalHttpClient();


        for (int i = 1; i <= 45; i++) {
            client
                    .getProductName(i)
                    .subscribe(Util.subscriber("Sub-" + i));
        }

        Util.sleep(2);
    }
}
