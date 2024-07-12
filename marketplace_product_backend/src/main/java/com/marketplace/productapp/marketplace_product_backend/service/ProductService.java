package com.marketplace.productapp.marketplace_product_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.productapp.marketplace_product_backend.model.Product;
import com.marketplace.productapp.marketplace_product_backend.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProductsByTagName(String tagName) {
        return productRepository.findProductsByTagName(tagName);
    }

    public List<Product> findProductsByProductIds(List<String> productIds) {
        return productRepository.findProductsByProductIds(productIds);
    }
}