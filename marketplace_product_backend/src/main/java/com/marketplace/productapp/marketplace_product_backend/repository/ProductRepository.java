package com.marketplace.productapp.marketplace_product_backend.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.marketplace.productapp.marketplace_product_backend.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> findProductsByTagNames(List<String> tagNames) {
        String sql = "SELECT p.* FROM products p " +
                     "JOIN product_tag pt ON p.product_id = pt.product_id " +
                     "JOIN tags t ON pt.tag_id = t.tag_id " +
                     "WHERE t.name IN :tagNames";

        return entityManager.createNativeQuery(sql, Product.class)
                            .setParameter("tagNames", tagNames)
                            .getResultList();
    }

    public List<Product> findProductsByProductIds(List<Long> productIds) {
        String jpql = "SELECT p FROM products p " +
                      "WHERE p.product_id IN :productIds";

        return entityManager.createNativeQuery(jpql, Product.class)
        .setParameter("productIds", productIds)
        .getResultList();
    }

}