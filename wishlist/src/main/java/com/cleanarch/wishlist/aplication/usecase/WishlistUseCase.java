package com.cleanarch.wishlist.aplication.usecase;

import com.cleanarch.wishlist.domain.entity.Wishlist;
import com.cleanarch.wishlist.domain.repository.WishlistRepository;
import com.cleanarch.wishlist.domain.vo.ProductId;

import java.util.HashSet;

public class WishlistUseCase {

    private final WishlistRepository wishlistRepository;

    public WishlistUseCase(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void addProduct(String customerId, String productId) {
        Wishlist wishlist = wishlistRepository.findByCustomerId(customerId)
                .orElseGet(()-> new Wishlist(null, customerId, new HashSet<>()));
        //TODO: Validar aqui tamanho maximo da lista de desejos.

        //TODO: Validar aqui se o produto já existe na lista de desejos.

        wishlist.getProductsIds().add(new ProductId(productId));
        wishlistRepository.save(wishlist);
    }
}
