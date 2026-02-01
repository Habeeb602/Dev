package com.project.ecommerceapp.dto;

import com.project.ecommerceapp.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {

    private Long id;
    private String name;
    private String skucode;
    private String image;
    private String description;
    private Double price;

    private Category category;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;

}
