package com.marketplace.orderapp.marketplace_order_backend.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.marketplace.orderapp.marketplace_order_backend.model.Order;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertOrder(Order order) {
        String sql = "INSERT INTO `Order` (customer_id, order_date, total_amount) " +
                     "VALUES (:customerId, :orderDate, :totalAmount)";

        entityManager.createNativeQuery(sql)
                .setParameter("customerId", order.getCustomerId())
                .setParameter("orderDate", order.getOrderDate())
                .setParameter("totalAmount", order.getTotalAmount())
                .executeUpdate();
    }
}