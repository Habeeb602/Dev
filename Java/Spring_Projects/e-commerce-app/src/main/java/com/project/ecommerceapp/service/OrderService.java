package com.project.ecommerceapp.service;

import com.project.ecommerceapp.dto.OrderRequest;
import com.project.ecommerceapp.dto.OrderRequestFull;
import com.project.ecommerceapp.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse placeDirectOrder(OrderRequest orderRequest, Long userId);

    List<OrderResponse> getOrdersByUserId(Long userId);

    OrderResponse placeOrder(OrderRequestFull orderRequestFull);
}
