package com.project.ecommerceapp.service;

import com.project.ecommerceapp.dto.CategoryResponse;
import com.project.ecommerceapp.dto.CategoryRequest;

import java.util.List;

public interface CategoryService {

    CategoryResponse findById(Long id);
    List<CategoryResponse> findAll();

    CategoryResponse saveCategory(CategoryRequest categoryRequest);

    CategoryResponse updateCategory(CategoryRequest categoryRequest, Long id);

    Boolean deleteCategory(Long id);


}
