package com.project.ecommerceapp.dto;

import com.project.ecommerceapp.entity.CartItem;
import com.project.ecommerceapp.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartResponse {

    private Long id;
    private User user;
    private List<CartItemResponse> cartItemResponses;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
