package com.marketplace.orderapp.marketplace_order_backend.controller.validator;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.marketplace.orderapp.marketplace_order_backend.controller.request.OrderItemRequest;
import com.marketplace.orderapp.marketplace_order_backend.controller.request.OrderRequest;

@Component
public class OrderCreateValidator {

    public void validate(OrderRequest orderRequest) {
        // Check if customerId is present
        if (orderRequest.getCustomerId() == null) {
            throw new IllegalArgumentException("customerId is missing");
        }

        // Check if orderItems list is not empty
        List<OrderItemRequest> orderItemRequests = orderRequest.getOrderItems();
        if (CollectionUtils.isEmpty(orderItemRequests)) {
            throw new IllegalArgumentException("orderItems list is empty");
        }

        // Check if each orderItem has a valid productId
        for (OrderItemRequest orderItemRequest : orderItemRequests) {
            if (orderItemRequest.getProductId() == null) {
                throw new IllegalArgumentException("productId is missing for one or more orderItems");
            }
        }
    }
}