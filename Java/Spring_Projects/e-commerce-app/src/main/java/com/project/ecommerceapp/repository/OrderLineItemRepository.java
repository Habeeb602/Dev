package com.project.ecommerceapp.repository;

import com.project.ecommerceapp.entity.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {

    List<OrderLineItem> findByOrderId(Long id);
}
