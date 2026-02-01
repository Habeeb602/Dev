package com.project.ecommerceapp.repository;

import com.project.ecommerceapp.entity.Cart;
import com.project.ecommerceapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUser(User user);
}
