package com.example.ecommerce.controller;


import com.example.ecommerce.entity.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return product;
    }
}
