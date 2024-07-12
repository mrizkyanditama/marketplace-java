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

    @GetMapping("")
    public List<Product> getProducts(@RequestParam(name = "tagNames", required = false) List<String> tagNames, @RequestParam(name = "productIds", required = false) List<Long> productIds) {
        if (tagNames != null && !tagNames.isEmpty()) {
            return productService.getProductsByTagNames(tagNames);
        } else {
            return productService.findProductsByProductIds(productIds);
        }
    }
}