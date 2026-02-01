package com.spring.security.springsecurity1.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GreetingsController {


    @GetMapping("/greetings")
    public ResponseEntity<String> greetings(){
        return ResponseEntity.ok("Welcome to Spring Security");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok("Good Bye, See you later!");
    }



}
