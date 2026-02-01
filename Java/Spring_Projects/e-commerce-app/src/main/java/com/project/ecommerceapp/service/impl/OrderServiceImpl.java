package com.project.ecommerceapp.service.impl;

import com.project.ecommerceapp.dto.*;
import com.project.ecommerceapp.entity.Order;
import com.project.ecommerceapp.entity.OrderLineItem;
import com.project.ecommerceapp.entity.User;
import com.project.ecommerceapp.exception.ProductNotFoundException;
import com.project.ecommerceapp.exception.UserNotFoundException;
import com.project.ecommerceapp.repository.OrderLineItemRepository;
import com.project.ecommerceapp.repository.OrderRepository;
import com.project.ecommerceapp.repository.ProductRepository;
import com.project.ecommerceapp.repository.UserRepository;
import com.project.ecommerceapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final OrderLineItemRepository orderLineItemRepository;

    private final ProductRepository productRepository;

    @Override
    public OrderResponse placeDirectOrder(OrderRequest orderRequest, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with ID: " + userId + " not present!"));
        double orderPrice = 0;

        List<OrderLineItem> orderLineItems = orderRequest.getOrderLineItems().stream().map(this::mapToOrderLineItem).toList();

        for(OrderLineItem orderLineItem: orderLineItems){
            orderPrice += orderLineItem.getProduct().getPrice() * orderLineItem.getQuantity();
        }

        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setOrderPrice(orderPrice);
        order.setOrderStatus("Placed");
        order.setUser(user);
        order.setExpectedDeliveryDate(order.getOrderDate().plusDays(5));

        Order savedOrder = orderRepository.save(order);

        for(OrderLineItem orderLineItem: orderLineItems){
            orderLineItem.setOrder(savedOrder);
            orderLineItemRepository.save(orderLineItem);
        }

        return OrderResponse
                .builder()
                .id(savedOrder.getId())
                .orderDate(savedOrder.getOrderDate())
                .orderStatus(savedOrder.getOrderStatus())
                .orderPrice(savedOrder.getOrderPrice())
                .expectedDeliveryDate(savedOrder.getExpectedDeliveryDate())
                .orderLineItemsResponse(getOrderLineItemsByOrder(savedOrder).stream().map(orderLineItem -> mapToOrderLineItemResponse(orderLineItem)).collect(Collectors.toList()))
                .created_at(savedOrder.getCreated_at())
                .modified_at(savedOrder.getModified_at())
                .build();
    }

    @Override
    public List<OrderResponse> getOrdersByUserId(Long userId) {
        return orderRepository.getOrdersByUserId(userId).stream().map(order -> mapToOrderResponse(order)).collect(Collectors.toList());
    }

    @Override
    public OrderResponse placeOrder(OrderRequestFull orderRequestFull) {

        long userId = orderRequestFull.getUser().getId();
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("No User present with ID:" + userId));
        List<OrderLineItem> orderLineItems = orderRequestFull.getOrderLineItemRequests().stream().map(orderLineItemRequest -> mapToOrderLineItem(orderLineItemRequest)).collect(Collectors.toList());
        double orderPrice = 0;
        for(OrderLineItem orderLineItem: orderLineItems) {
            orderPrice += orderLineItem.getQuantity() * orderLineItem.getProduct().getPrice();
        }
        Order order = new Order();
        order.setOrderStatus(orderRequestFull.getOrderStatus());
        order.setOrderDate(orderRequestFull.getOrderDate());
        order.setUser(user);
        order.setOrderPrice(orderPrice);
        order.setExpectedDeliveryDate(orderRequestFull.getExpectedDeliveryDate());
        order.setCreated_at(LocalDateTime.now());
        order.setModified_at(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);

        for(OrderLineItem orderLineItem: orderLineItems){
            orderLineItem.setOrder(savedOrder);
            orderLineItemRepository.save(orderLineItem);
        }


        return OrderResponse
                .builder()
                .id(savedOrder.getId())
                .orderDate(savedOrder.getOrderDate())
                .orderPrice(savedOrder.getOrderPrice())
                .orderStatus(savedOrder.getOrderStatus())
                .expectedDeliveryDate(savedOrder.getExpectedDeliveryDate())
                .user(user)
                .orderLineItemsResponse(getOrderLineItemsByOrder(savedOrder).stream().map(orderLineItem -> mapToOrderLineItemResponse(orderLineItem)).collect(Collectors.toList()))
                .build();

    }

    private OrderResponse mapToOrderResponse(Order order) {
        List<OrderLineItemResponse> orderLineItemResponses = orderLineItemRepository.findByOrderId(order.getId()).stream().map(orderLineItem -> mapToOrderLineItemResponse(orderLineItem)).collect(Collectors.toList());
        OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
        orderResponse.setOrderLineItemsResponse(orderLineItemResponses);
        return orderResponse;
    }

    private OrderLineItemResponse mapToOrderLineItemResponse(OrderLineItem orderLineItem) {
        return modelMapper.map(orderLineItem, OrderLineItemResponse.class);
    }

    private OrderLineItem mapToOrderLineItem(OrderLineItemRequest orderLineItemRequest) {
        OrderLineItem orderLineItem = modelMapper.map(orderLineItemRequest, OrderLineItem.class);
        Long productId = orderLineItem.getProduct().getId();
        orderLineItem.setProduct(productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("OrderService: Product with ID: " + productId + " not present!")));
        return orderLineItem;
    }

    private List<OrderLineItem> getOrderLineItemsByOrder(Order order){
        return orderLineItemRepository.findByOrderId(order.getId());
    }
}
