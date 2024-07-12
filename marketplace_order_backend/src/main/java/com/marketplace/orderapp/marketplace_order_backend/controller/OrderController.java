package com.marketplace.orderapp.marketplace_order_backend.controller;

import com.marketplace.orderapp.marketplace_order_backend.controller.mapper.OrderCreateMapper;
import com.marketplace.orderapp.marketplace_order_backend.controller.request.OrderRequest;
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

    private final OrderCreateMapper orderCreateMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderCreateMapper orderCreateMapper) {
        this.orderService = orderService;
        this.orderCreateMapper = orderCreateMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            Order order = orderCreateMapper.mapToOrder(orderRequest);
            order.setOrderItems(orderCreateMapper.mapToOrderItems(orderRequest.getOrderItems()));

            Order result = orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (InternalError e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error: " + e.getMessage());
        }
    }
}
