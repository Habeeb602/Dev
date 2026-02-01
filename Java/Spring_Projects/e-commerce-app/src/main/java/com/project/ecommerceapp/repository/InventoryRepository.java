package com.project.ecommerceapp.repository;

import com.project.ecommerceapp.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findInventoryByProductId(Long productId);
}
