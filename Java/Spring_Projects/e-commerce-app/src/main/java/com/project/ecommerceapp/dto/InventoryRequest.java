package com.project.ecommerceapp.dto;

import com.project.ecommerceapp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRequest {

    private Long quantity;
    private Product product;
}
