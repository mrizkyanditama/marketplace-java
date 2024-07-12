package com.marketplace.orderapp.marketplace_order_backend.controller.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderRequest {

    private Long customerId;
    private LocalDateTime orderDate;
    private List<OrderItemRequest> orderItems;

    // Getters and setters

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItemRequest> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemRequest> orderItems) {
        this.orderItems = orderItems;
    }
}