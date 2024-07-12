package com.marketplace.orderapp.marketplace_order_backend.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.marketplace.orderapp.marketplace_order_backend.controller.request.OrderItemRequest;
import com.marketplace.orderapp.marketplace_order_backend.controller.request.OrderRequest;
import com.marketplace.orderapp.marketplace_order_backend.model.Order;
import com.marketplace.orderapp.marketplace_order_backend.model.OrderItem;

@Component
public class OrderCreateMapper {
    public Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setCustomerId(orderRequest.getCustomerId());
        order.setOrderDate(orderRequest.getOrderDate());
        // You can set other fields as needed
        return order;
    }

    public List<OrderItem> mapToOrderItems(List<OrderItemRequest> orderItemRequests) {
        return orderItemRequests.stream()
                .map(this::mapToOrderItem)
                .collect(Collectors.toList());
    }

    public OrderItem mapToOrderItem(OrderItemRequest orderItemRequest) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(orderItemRequest.getProductId());
        orderItem.setPrice(orderItemRequest.getPrice());
        orderItem.setQuantity(orderItemRequest.getQuantity());
        // You can set other fields as needed
        return orderItem;
    }
}
