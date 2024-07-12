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
        String sql = "SELECT p.* FROM Product p " +
                     "JOIN Product_Tag pt ON p.product_id = pt.product_id " +
                     "JOIN Tag t ON pt.tag_id = t.tag_id " +
                     "WHERE t.name IN :tagNames";

        return entityManager.createNativeQuery(sql, Product.class)
                            .setParameter("tagNames", tagNames)
                            .getResultList();
    }

    public List<Product> findProductsByProductIds(List<String> productIds) {
        String jpql = "SELECT p FROM Product p " +
                      "WHERE p.productId IN :productIds";

        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        query.setParameter("productIds", productIds);
        return query.getResultList();
    }

}