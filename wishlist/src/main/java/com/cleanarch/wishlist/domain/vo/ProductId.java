package com.cleanarch.wishlist.domain.vo;

public record ProductId(String value) {
    public ProductId {
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException("ProductId cannot be null or blank");
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProductId(String value1))) return false;
        return value.equals(value1);
    }

    @Override
    public String toString(){
        return value;
    }
}
