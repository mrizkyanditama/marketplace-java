package com.marketplace.productapp.marketplace_product_backend.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ProductTagId implements Serializable {
    private Long productId;
    private Long tagId;

    // Getters and setters
}