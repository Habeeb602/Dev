package com.project.ecommerceapp.controller;


import com.project.ecommerceapp.dto.CategoryRequest;
import com.project.ecommerceapp.dto.CategoryResponse;
import com.project.ecommerceapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryResponse> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public CategoryResponse getCategoryById(@PathVariable(value = "id") Long id){
        return categoryService.findById(id);
    }

    @PostMapping("/category")
    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.saveCategory(categoryRequest);
    }

    @PatchMapping("/category/{id}")
    public CategoryResponse updateCategory(@PathVariable(value = "id") Long id, @RequestBody CategoryRequest categoryRequest){
        return categoryService.updateCategory(categoryRequest, id);
    }

    @DeleteMapping("/category/{id}")
    public Boolean deleteCategory(@PathVariable(value = "id") Long id){
        return categoryService.deleteCategory(id);
    }
}
