package com.project.ecommerceapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SampleController {

    @GetMapping("/data")
    public String data(){
        return "Here is the data!";
    }
}
