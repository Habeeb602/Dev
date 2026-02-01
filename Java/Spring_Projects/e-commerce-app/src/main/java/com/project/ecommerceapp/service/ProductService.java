package com.project.ecommerceapp.service;

import com.project.ecommerceapp.dto.ProductRequest;
import com.project.ecommerceapp.dto.ProductResponse;


import java.util.List;

public interface ProductService {

    ProductResponse findById(Long id);
    List<ProductResponse> findAll();

    ProductResponse saveProduct(ProductRequest productRequest);

    ProductResponse updateProduct(ProductRequest productRequest, Long id);

    Boolean deleteProduct(Long id);

}
