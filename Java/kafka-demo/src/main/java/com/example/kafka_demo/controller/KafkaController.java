package com.example.kafka_demo.controller;


import com.example.kafka_demo.kafka.KafkaJsonProducer;
import com.example.kafka_demo.kafka.KafkaProducer;
import com.example.kafka_demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    public KafkaController(KafkaProducer kafkaProducer, KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }


    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){

        kafkaProducer.sendMessage(message);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Message sent to Kafka successfully");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("JSON message sent to Kafka successfully");
    }
}
