package com.project.ecommerceapp.dto;

import com.project.ecommerceapp.entity.OrderLineItem;
import com.project.ecommerceapp.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private Long id;

    private User user;
    private String orderStatus;
    private LocalDate orderDate;
    private LocalDate expectedDeliveryDate;
    private Double orderPrice;

    private List<OrderLineItemResponse> orderLineItemsResponse;


    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
