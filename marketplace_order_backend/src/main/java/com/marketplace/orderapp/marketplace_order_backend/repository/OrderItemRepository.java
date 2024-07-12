package com.marketplace.orderapp.marketplace_order_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import com.marketplace.orderapp.marketplace_order_backend.model.OrderItem;
import java.math.BigDecimal;

@Repository
public class OrderItemRepository {

    @PersistenceContext
    EntityManager entityManager;
    public void insertOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO order_items (order_item_id, order_id, product_id, quantity, price) " +
                     "VALUES (:orderItemId, :orderId, :productId, :quantity, :price)";

        entityManager.createNativeQuery(sql)
                     .setParameter("orderItemId", orderItem.getOrderItemId())
                     .setParameter("orderId", orderItem.getOrder().getOrderId())
                     .setParameter("productId", orderItem.getProductId())
                     .setParameter("quantity", orderItem.getQuantity())
                     .setParameter("price", orderItem.getPrice())
                     .executeUpdate();
    }
}