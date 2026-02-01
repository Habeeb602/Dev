package com.project.ecommerceapp.dto;

import com.project.ecommerceapp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponse {


    private Long id;
    private Long quantity;
    private Product product;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
