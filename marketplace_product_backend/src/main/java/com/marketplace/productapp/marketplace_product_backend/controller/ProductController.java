package com.marketplace.productapp.marketplace_product_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.productapp.marketplace_product_backend.model.Product;
import com.marketplace.productapp.marketplace_product_backend.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/tags")
    public List<Product> getProductsByTagNames(@RequestParam("tagNames") List<String> tagNames) {
        return productService.getProductsByTagNames(tagNames);
    }

    @PostMapping("/ids")
    public List<Product> getProductsByIds(@RequestBody List<String> productIds) {
        return productService.findProductsByProductIds(productIds);
    }
}