package com.example.reactive.section_3;

import com.example.reactive.common.Util;
import com.example.reactive.section_3.Util.StockSubscriber;
import com.example.reactive.section_3.client.ExternalHttpClient;

public class AssignmentTest {


    public static void main(String[] args) {
        var client = new ExternalHttpClient();

        client.getStockPrice()
                .subscribe(new StockSubscriber<>());

        Util.sleep(25);
    }
}
