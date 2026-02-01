package com.project.ecommerceapp.repository;

import com.project.ecommerceapp.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, String> {

    List<CartItem> findByCartId(Long id);

}
