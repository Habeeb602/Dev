package com.project.ecommerceapp.controller;

import com.project.ecommerceapp.dto.OrderRequest;
import com.project.ecommerceapp.dto.OrderRequestFull;
import com.project.ecommerceapp.dto.OrderResponse;
import com.project.ecommerceapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/{user_id}")
    public ResponseEntity<OrderResponse> placeDirectOrder(@RequestBody OrderRequest orderRequest, @PathVariable(value = "user_id") Long id){
        OrderResponse orderResponse = orderService.placeDirectOrder(orderRequest, id);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping("/order/{user_id}")
    public ResponseEntity<List<OrderResponse>> getOrders(@PathVariable(value = "user_id") Long userId){
        List<OrderResponse> orderResponses = orderService.getOrdersByUserId(userId);
        return new ResponseEntity<>(orderResponses, HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequestFull orderRequestFull){
        OrderResponse orderResponse = orderService.placeOrder(orderRequestFull);

        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

}
