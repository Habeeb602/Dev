package com.project.ecommerceapp.service.impl;

import com.project.ecommerceapp.dto.CategoryRequest;
import com.project.ecommerceapp.dto.CategoryResponse;
import com.project.ecommerceapp.entity.Category;
import com.project.ecommerceapp.exception.CategoryNotFoundException;
import com.project.ecommerceapp.repository.CategoryRepository;
import com.project.ecommerceapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public CategoryResponse findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with ID: " + id + " is not found"));
        return modelMapper.map(category, CategoryResponse.class);
    }

    @Override
    public List<CategoryResponse> findAll() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream().map(this::toCategoryResponse).collect(Collectors.toList());
    }

    private CategoryResponse toCategoryResponse(Category category) {
        return modelMapper.map(category, CategoryResponse.class);
    }

    @Override
    public CategoryResponse saveCategory(CategoryRequest categoryRequest) {
        Long id = categoryRepository.save(modelMapper.map(categoryRequest, Category.class)).getId();
        Category savedCategory = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with ID: " + id + " is not found"));
        return modelMapper.map(savedCategory, CategoryResponse.class);
    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest categoryRequest, Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with ID: " + id + " is not found"));

        Optional.ofNullable(categoryRequest.getName()).ifPresent(category::setName);
        Optional.ofNullable(categoryRequest.getDescription()).ifPresent(category::setDescription);
        category.setModified_at(LocalDateTime.now());

        Category updatedCategory = categoryRepository.save(category);

        return modelMapper.map(updatedCategory, CategoryResponse.class);
    }

    @Override
    public Boolean deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with ID: " + id + " is not found"));
        categoryRepository.deleteById(id);
        return true;
    }
}
