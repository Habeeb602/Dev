package com.example.wikimedia_producer.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaChangesHandler implements EventHandler {

    private final String topic;
    private final KafkaTemplate<String,String> template;
    private static final Logger log = LoggerFactory.getLogger(WikimediaChangesHandler.class);

    public WikimediaChangesHandler(String topic, KafkaTemplate<String,String> template){
        this.topic = topic;
        this.template = template;
    }

    @Override
    public void onOpen() throws Exception {
        log.info("EventHandler getting opened!");
    }

    @Override
    public void onClosed() throws Exception {
        log.info("EventHandler getting closed!");
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        log.info("onMessage: message -> {}", messageEvent.getData());
        template.send(topic, messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {
        log.info("EventHandler onComment -> {}", s);
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("EventHandler onError -> {}", throwable.getMessage());
    }
}
