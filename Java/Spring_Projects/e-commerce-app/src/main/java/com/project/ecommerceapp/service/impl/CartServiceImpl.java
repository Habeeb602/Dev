package com.project.ecommerceapp.service.impl;

import com.project.ecommerceapp.dto.CartItemRequest;
import com.project.ecommerceapp.dto.CartItemResponse;
import com.project.ecommerceapp.dto.CartResponse;
import com.project.ecommerceapp.entity.Cart;
import com.project.ecommerceapp.entity.CartItem;
import com.project.ecommerceapp.entity.User;
import com.project.ecommerceapp.exception.UserNotFoundException;
import com.project.ecommerceapp.repository.CartItemRepository;
import com.project.ecommerceapp.repository.CartRepository;
import com.project.ecommerceapp.repository.UserRepository;
import com.project.ecommerceapp.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    private final CartItemRepository cartItemRepository;

    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);


    private Cart getCartByUserId(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " is not present"));

        Cart cart = cartRepository.findByUser(user);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setCartItems(new ArrayList<>());
            cartRepository.save(cart);
            return cartRepository.findByUser(user);
        }

        return cart;
    }
    @Override
    public CartResponse getCartByUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " is not present"));
        Cart cart = getCartByUserId(id);

        return CartResponse
                .builder()
                .user(user)
                .cartItemResponses(getCartItemByCartId(cart.getId()).stream().map(cartItem -> mapToCartItemResponse(cartItem)).collect(Collectors.toList()))
                .id(cart.getId())
                .created_at(cart.getCreated_at())
                .modified_at(cart.getModified_at())
                .build();
    }

    private CartItemResponse mapToCartItemResponse(CartItem cartItem) {
        return modelMapper.map(cartItem, CartItemResponse.class);
    }

    private List<CartItem> getCartItemByCartId(Long id){
        return cartItemRepository.findByCartId(id);
    }


    @Override
    public CartResponse saveCartItems(List<CartItemRequest> cartItemRequests, Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " is not present"));
        Cart cart = getCartByUserId(id);
        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());
//        List<CartItem> newCartItems = new ArrayList<>();
        for(CartItemRequest cartItemRequest: cartItemRequests){
            boolean exists = false;
            for(CartItem cartItem: cartItems){
                if(Objects.equals(cartItemRequest.getProduct().getId(), cartItem.getProduct().getId())){
                    Long newQuantity = cartItem.getQuantity() + cartItemRequest.getQuantity();
                    cartItem.setQuantity(newQuantity);
                    cartItemRepository.save(cartItem);

                    exists = true;
                    break;
                }
            }
            if(!exists){
                CartItem cartItem = modelMapper.map(cartItemRequest, CartItem.class);
                cartItem.setUuid(UUID.randomUUID().toString());
                cartItem.setCart(cart);
                cartItemRepository.save(cartItem);
            }
        }

        cart.setModified_at(LocalDateTime.now());

        cartRepository.save(cart);

        return CartResponse
                .builder()
                .id(cart.getId())
                .user(user)
                .cartItemResponses(getCartItemByCartId(cart.getId()).stream().map(cartItem -> mapToCartItemResponse(cartItem)).collect(Collectors.toList()))
                .created_at(cart.getCreated_at())
                .modified_at(cart.getModified_at())
                .build();
    }


}
