package com.project.ecommerceapp.dto;

import com.project.ecommerceapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

//    private User user;
//    private String orderStatus;
//    private LocalDate orderDate;
//    private LocalDate expectedDeliveryDate;
//    private Double orderPrice;

    private List<OrderLineItemRequest> orderLineItems;


}
