package com.example.kafka_demo.kafka;

import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String,String> template;
    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    public KafkaProducer(KafkaTemplate<String,String> template) {
        this.template = template;
    }

    public void sendMessage(String message){
        log.info(String.format("Inside sendMessage, message: %s", message));
        template.send("sample", message);
    }
}
