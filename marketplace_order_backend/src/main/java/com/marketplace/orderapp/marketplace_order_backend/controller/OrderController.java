package com.marketplace.orderapp.marketplace_order_backend.controller;

import com.marketplace.orderapp.marketplace_order_backend.model.Order;
import com.marketplace.orderapp.marketplace_order_backend.model.OrderItem;
import com.marketplace.orderapp.marketplace_order_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createOrder(@RequestBody Order order, @RequestBody List<OrderItem> orderItems) {
        try {
            Order createdOrder = orderService.createOrder(order, orderItems);
            return ResponseEntity.status(HttpStatus.OK).body(createdOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (InternalError e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error: " + e.getMessage());
        }
    }
}
