package com.marketplace.productapp.marketplace_product_backend.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product_tag")
@Data
public class ProductTag {
    @EmbeddedId
    private ProductTagId id;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @ManyToOne
    @MapsId("tagId")
    private Tag tag;

    // Getters and setters
}