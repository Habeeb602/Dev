package com.microservices.departmentservice.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value("${spring.boot.message}")
    private String message;


//    Once we change the message config value, we need to send a post request to http://localhost:8079/actuator/refresh
//    to refresh the config files
//    After that, we can see the changes once we send the get request to http://localhost:8079/message

    @GetMapping("/message")
    public String getMessage(){
        return message;
    }
}
