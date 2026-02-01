package com.project.ecommerceapp.repository;

import com.project.ecommerceapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
