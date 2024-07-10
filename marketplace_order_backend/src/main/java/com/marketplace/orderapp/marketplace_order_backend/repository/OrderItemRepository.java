package com.marketplace.orderapp.marketplace_order_backend.repository;

import org.springframework.stereotype.Repository;

import com.marketplace.orderapp.marketplace_order_backend.model.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class OrderItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO Order_Item (order_id, product_id, quantity, price) " +
                     "VALUES (:orderId, :productId, :quantity, :price)";

        entityManager.createNativeQuery(sql)
                .setParameter("orderId", orderItem.getOrder().getOrderId()) // Assuming OrderItem has a reference to Order
                .setParameter("productId", orderItem.getProductId())
                .setParameter("quantity", orderItem.getQuantity())
                .setParameter("price", orderItem.getPrice())
                .executeUpdate();
    }
}