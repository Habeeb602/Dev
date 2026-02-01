package com.example.kafka_demo.kafka;

import com.example.kafka_demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "jsonSample", groupId = "myGroup")
    public void consume(User user){
        log.info("Json message received -> {}", user);
    }
}
