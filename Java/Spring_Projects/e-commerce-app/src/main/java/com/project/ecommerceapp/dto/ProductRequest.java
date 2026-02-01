package com.project.ecommerceapp.dto;

import com.project.ecommerceapp.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequest {

    private String name;
    private String skucode;
    private String image;
    private String description;
    private Double price;

    private Category category;

}
