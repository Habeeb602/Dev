package com.example.wikimedia_producer.service;


import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {
    private static final Logger log = LoggerFactory.getLogger(WikimediaChangesProducer.class);

    private final KafkaTemplate<String, String> template;

    public  WikimediaChangesProducer(KafkaTemplate<String, String> template){
        this.template = template;
    }

    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia_recent_change";
        String url = "https://api.tfl.gov.uk/AccidentStats/2010";
        WikimediaChangesHandler handler = new WikimediaChangesHandler(topic, template);

        try (EventSource eventSource = new EventSource.Builder(handler,URI.create(url)).build()) {
            eventSource.start();
            TimeUnit.MINUTES.sleep(10);
        }

    }


}
