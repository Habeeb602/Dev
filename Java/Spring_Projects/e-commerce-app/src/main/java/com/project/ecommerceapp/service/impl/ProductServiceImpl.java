package com.project.ecommerceapp.service.impl;

import com.project.ecommerceapp.dto.ProductRequest;
import com.project.ecommerceapp.dto.ProductResponse;
import com.project.ecommerceapp.entity.Product;
import com.project.ecommerceapp.exception.ProductNotFoundException;
import com.project.ecommerceapp.repository.ProductRepository;
import com.project.ecommerceapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID: " + id + " not found!"));

        ProductResponse productResponse = modelMapper.map(product, ProductResponse.class);
        return productResponse;
    }

    @Override
    public List<ProductResponse> findAll() {

        List<Product> products = productRepository.findAll();

        List<ProductResponse> productResponses = products.stream().map(this::toProductResponse).toList();

        return productResponses;
    }

    private ProductResponse toProductResponse(Product product) {
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {
        Long productId = productRepository.save(modelMapper.map(productRequest, Product.class)).getId();

        Product savedProduct = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product with ID: " + productId + " not found!"));
        return modelMapper.map(savedProduct, ProductResponse.class);
    }

    /*
    private String name;
    private String skucode;
    private String image;
    private String desc;
    private Double price;

    private Category category;*/

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest, Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID: " + id + " not found!"));

//        product.setName(productRequest.getName());
//        product.setSkucode(productRequest.getSkucode());
//        product.setImage();

        Optional.ofNullable(productRequest.getName()).ifPresent(product::setName);
        Optional.ofNullable(productRequest.getSkucode()).ifPresent(product::setSkucode);
        Optional.ofNullable(productRequest.getImage()).ifPresent(product::setImage);
        Optional.ofNullable(productRequest.getDescription()).ifPresent(product::setDescription);
        Optional.ofNullable(productRequest.getPrice()).ifPresent(product::setPrice);
        Optional.ofNullable(productRequest.getCategory()).ifPresent(product::setCategory);


        product.setModified_at(LocalDateTime.now());

        Product updatedProduct = productRepository.save(product);

        return modelMapper.map(updatedProduct, ProductResponse.class);
    }

    @Override
    public Boolean deleteProduct(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID: " + id + " not found!"));
        productRepository.deleteById(id);
        return true;
    }
}
