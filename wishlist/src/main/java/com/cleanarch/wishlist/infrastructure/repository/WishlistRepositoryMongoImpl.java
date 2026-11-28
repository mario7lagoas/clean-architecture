package com.cleanarch.wishlist.infrastructure.repository;

import com.cleanarch.wishlist.domain.entity.Wishlist;
import com.cleanarch.wishlist.domain.repository.WishlistRepository;
import com.cleanarch.wishlist.infrastructure.persistence.WishlistDocument;
import com.cleanarch.wishlist.infrastructure.persistence.WishlistMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class WishlistRepositoryMongoImpl implements WishlistRepository {
    private final WishlistMongoSpringData repositoryMongo;
    private final WishlistMapper wishlistMapper;

    public WishlistRepositoryMongoImpl(WishlistMongoSpringData repositoryMongo, WishlistMapper wishlistMapper) {
        this.repositoryMongo = repositoryMongo;
        this.wishlistMapper = wishlistMapper;
    }

    @Override
    public Optional<Wishlist> findByCustomerId(String customerId) {
        return repositoryMongo.findByCustomerId(customerId)
                .map(wishlistMapper::toDomain);
    }

    @Override
    public void save(Wishlist wishlist) {
        WishlistDocument doc = wishlistMapper.toDocument(wishlist);
        repositoryMongo.save(doc);
    }
}
