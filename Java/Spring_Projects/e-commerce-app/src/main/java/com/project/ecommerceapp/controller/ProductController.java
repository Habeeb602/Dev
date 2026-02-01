package com.project.ecommerceapp.controller;


import com.project.ecommerceapp.dto.ProductRequest;
import com.project.ecommerceapp.dto.ProductResponse;
import com.project.ecommerceapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public List<ProductResponse> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public ProductResponse getProductById(@PathVariable(value = "id") Long id){
        return productService.findById(id);
    }

    @PostMapping("/product")
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.saveProduct(productRequest);
    }

    @PatchMapping("/product/{id}")
    public ProductResponse updateProduct(@PathVariable(value = "id") Long id, @RequestBody ProductRequest productRequest){
        return productService.updateProduct(productRequest, id);
    }

    @DeleteMapping("/product/{id}")
    public Boolean deleteProduct(@PathVariable(value = "id") Long id){
        return productService.deleteProduct(id);
    }

}
