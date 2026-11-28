package com.cleanarch.wishlist.infrastructure.persistence;

import com.cleanarch.wishlist.domain.entity.Wishlist;
import com.cleanarch.wishlist.domain.vo.ProductId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface WishlistMapper {
    WishlistMapper INSTANCE = Mappers.getMapper(WishlistMapper.class);

    WishlistDocument toDocument(Wishlist wishlist);
    Wishlist toDomain(WishlistDocument wishlistDocument);

    //Metodos auxiliares para conversão Set<ProductId> para Set<String> e vice-versa
    default Set<String> map(Set<ProductId> productsIds) {
        if (productsIds == null) return null;
        return productsIds.stream().map(ProductId::toString).collect(Collectors.toSet());
    }

    default Set<ProductId> mapToProductId(Set<String> productsIds) {
        if (productsIds == null) return null;
        return productsIds.stream().map(ProductId::new).collect(Collectors.toSet());
    }
}
