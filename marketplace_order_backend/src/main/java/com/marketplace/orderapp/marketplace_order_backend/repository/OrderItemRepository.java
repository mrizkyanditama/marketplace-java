package com.marketplace.orderapp.marketplace_order_backend.repository;

import org.springframework.stereotype.Repository;

import com.marketplace.orderapp.marketplace_order_backend.model.OrderItem;
import com.marketplace.orderapp.marketplace_order_backend.shared.utils.RandomUniqueIdUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class OrderItemRepository {
    private static final String ORDER_ITEM_REPOSITORY_EVENT_CODE = "002";

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int insertOrderItem(OrderItem orderItem) {
        String uniqueId = RandomUniqueIdUtil.generateUniqueId(ORDER_ITEM_REPOSITORY_EVENT_CODE);
        orderItem.setOrderItemId(uniqueId);

        String sql = "INSERT INTO Order_Item (order_id, product_id, quantity, price) " +
                     "VALUES (:orderId, :productId, :quantity, :price)";

        return entityManager.createNativeQuery(sql)
                .setParameter("orderId", orderItem.getOrder().getOrderId()) // Assuming OrderItem has a reference to Order
                .setParameter("productId", orderItem.getProductId())
                .setParameter("quantity", orderItem.getQuantity())
                .setParameter("price", orderItem.getPrice())
                .executeUpdate();
    }
}