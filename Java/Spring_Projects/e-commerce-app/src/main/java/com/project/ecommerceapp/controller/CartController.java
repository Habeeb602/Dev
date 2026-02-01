package com.project.ecommerceapp.controller;


import com.project.ecommerceapp.dto.CartItemRequest;
import com.project.ecommerceapp.dto.CartResponse;
import com.project.ecommerceapp.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CartController {

    private final CartService cartService;

    @GetMapping("/cart/{user_id}")
    public ResponseEntity<CartResponse> getCart(@PathVariable(value = "user_id") Long id){
        CartResponse cartResponse = cartService.getCartByUser(id);
        return new ResponseEntity<>(cartResponse, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/cart/{user_id}")
    public ResponseEntity<CartResponse> createCart(@RequestBody List<CartItemRequest> cartItemRequests, @PathVariable(value = "user_id") Long id){
        CartResponse cartResponse = cartService.saveCartItems(cartItemRequests, id);
        return new ResponseEntity<>(cartResponse, HttpStatus.CREATED);
    }

}
