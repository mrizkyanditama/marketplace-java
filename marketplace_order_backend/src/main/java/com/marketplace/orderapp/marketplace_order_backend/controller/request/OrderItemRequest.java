package com.marketplace.orderapp.marketplace_order_backend.controller.request;

import java.math.BigDecimal;

public class OrderItemRequest {

    private String productId;
    private BigDecimal price;
    private int quantity;

    // Getters and setters

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productName) {
        this.productId = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
