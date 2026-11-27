package com.cleanarch.wishlist.domain.entity;

import com.cleanarch.wishlist.domain.vo.ProductId;

import java.util.HashSet;
import java.util.Set;

public class Wishlist {
    private String id;
    private String customerId;
    private Set<ProductId> productsIds = new HashSet<>();

    public Wishlist(){}
    public Wishlist(String id, String customerId, Set<ProductId> productsIds) {
        this.id = id;
        this.customerId = customerId;
        this.productsIds = productsIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Set<ProductId> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(Set<ProductId> productsIds) {
        this.productsIds = productsIds;
    }
}
