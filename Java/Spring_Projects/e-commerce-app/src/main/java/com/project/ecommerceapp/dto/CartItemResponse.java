package com.project.ecommerceapp.dto;

import com.project.ecommerceapp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponse {

    private String uuid;
    private Product product;
    private Long quantity;
}
