package com.marketplace.orderapp.marketplace_order_backend.repository;

import org.springframework.stereotype.Repository;


import com.marketplace.orderapp.marketplace_order_backend.model.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertOrder(Order order) {
        String sql = "INSERT INTO orders (order_id, customer_id, order_date, total_amount) " +
                     "VALUES (:orderId, :customerId, :orderDate, :totalAmount)";
        
        entityManager.createNativeQuery(sql)
                     .setParameter("orderId", order.getOrderId())
                     .setParameter("customerId", order.getCustomerId())
                     .setParameter("orderDate",order.getOrderDate())
                     .setParameter("totalAmount", order.getTotalAmount())
                     .executeUpdate();
    }
}