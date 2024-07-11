package com.marketplace.orderapp.marketplace_order_backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marketplace.orderapp.marketplace_order_backend.model.Order;
import com.marketplace.orderapp.marketplace_order_backend.model.OrderItem;
import com.marketplace.orderapp.marketplace_order_backend.repository.OrderItemRepository;
import com.marketplace.orderapp.marketplace_order_backend.repository.OrderRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public Order createOrder(Order order, List<OrderItem> orderItems) throws IllegalArgumentException {
        validateOrder(order, orderItems);

        // Set order date if not provided
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDateTime.now());
        }

        BigDecimal totalAmount = calculateTotalAmount(orderItems);
        order.setTotalAmount(totalAmount);

        try {
            int inserted = orderRepository.insertOrder(order);

            if (inserted < 1) {
                throw new InternalError("Order not successfully inserted");
            }
        } catch (Exception e) {
            throw new InternalError("Failed to save order", e);
        }

        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(order);
            try {
                int inserted = orderItemRepository.insertOrderItem(orderItem);

                if (inserted < 1) {
                    throw new InternalError("Order Item not successfully inserted");
                }
            } catch (Exception e) {
                throw new InternalError("Failed to save order item with id: " + orderItem.getOrderItemId(), e);
            }
        }

        return order;
    }

    private void validateOrder(Order order, List<OrderItem> orderItems) throws IllegalArgumentException {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (orderItems == null || orderItems.isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }
    }

    private BigDecimal calculateTotalAmount(List<OrderItem> orderItems) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (OrderItem orderItem : orderItems) {
            BigDecimal itemTotal = orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()));
            totalAmount = totalAmount.add(itemTotal);
        }
        return totalAmount;
    }
}