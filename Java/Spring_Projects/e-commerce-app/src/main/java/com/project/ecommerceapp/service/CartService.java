package com.project.ecommerceapp.service;

import com.project.ecommerceapp.dto.CartItemRequest;
import com.project.ecommerceapp.dto.CartResponse;
import com.project.ecommerceapp.entity.Cart;

import java.util.List;

public interface CartService {

    CartResponse getCartByUser(Long id);
    CartResponse saveCartItems(List<CartItemRequest> cartItemRequests, Long id);

}
