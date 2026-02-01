package com.microservices.orderservice.service;

import java.util.Arrays;
import java.util.List;

import java.util.UUID;

import com.microservices.orderservice.dto.InventoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.orderservice.dto.OrderLineItemsDto;
import com.microservices.orderservice.dto.OrderRequest;
import com.microservices.orderservice.dto.OrderResponse;
import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.model.OrderLineItems;
import com.microservices.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final WebClient webClient;
	
	
	
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtosList().stream().map(OrderLineItemsDto -> mapToOrderLineItems(OrderLineItemsDto)).toList();
		order.setOrderLineItems(orderLineItems);

		List<String> skuCodes =  order.getOrderLineItems().stream().map(OrderLineItems::getSkuCode).toList();

		InventoryResponse[] inventoryResponseArray = webClient.get()
				.uri("http://localhost:5002/api/inventory",
						uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
				.retrieve()
				.bodyToMono(InventoryResponse[].class)
				.block();

		boolean result = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);

		if(result){
			orderRepository.save(order);
		}
		else{
			throw new IllegalArgumentException("Product out of stock - please try later!");
		}

	}

	private OrderLineItems mapToOrderLineItems(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		
		
		return orderLineItems;
	}
	
	public List<OrderResponse> getOrders() {
		List<Order> orders = orderRepository.findAll();
		
		return orders.stream().map(order -> mapToOrderResponse(order)).toList();
	}

	private OrderResponse mapToOrderResponse(Order order) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderNumber(order.getOrderNumber());
		
		List<OrderLineItemsDto> orderLineItemsDtos = order.getOrderLineItems().stream().map(orderLineItems -> mapToOrderLineItemDto(orderLineItems)).toList();
		
		orderResponse.setOrderLineItemsDtosList(orderLineItemsDtos);
		
		return orderResponse;
	}

	private OrderLineItemsDto mapToOrderLineItemDto(OrderLineItems orderLineItems) {
		OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto();
		orderLineItemsDto.setId(orderLineItems.getId());
		orderLineItemsDto.setPrice(orderLineItems.getPrice());
		orderLineItemsDto.setQuantity(orderLineItems.getQuantity());
		orderLineItemsDto.setSkuCode(orderLineItems.getSkuCode());
		return orderLineItemsDto;
		
	}
	
}
