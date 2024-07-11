package com.marketplace.orderapp.marketplace_order_backend.repository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.marketplace.orderapp.marketplace_order_backend.model.Order;
import com.marketplace.orderapp.marketplace_order_backend.shared.utils.RandomUniqueIdUtil;

@Repository
public class OrderRepository {
    private static final String ORDER_REPOSITORY_EVENT_CODE = "001";

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int insertOrder(Order order) {
        String uniqueId = RandomUniqueIdUtil.generateUniqueId(ORDER_REPOSITORY_EVENT_CODE);
        order.setOrderId(uniqueId);

        String sql = "INSERT INTO `Order` (customer_id, order_date, total_amount) " +
                     "VALUES (:customerId, :orderDate, :totalAmount)";

        return entityManager.createNativeQuery(sql)
                .setParameter("customerId", order.getCustomerId())
                .setParameter("orderDate", order.getOrderDate())
                .setParameter("totalAmount", order.getTotalAmount())
                .executeUpdate();
    }

}