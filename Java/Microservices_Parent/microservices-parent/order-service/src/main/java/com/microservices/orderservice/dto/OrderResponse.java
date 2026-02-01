package com.microservices.orderservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
	private String orderNumber;
	private List<OrderLineItemsDto> orderLineItemsDtosList;
}
