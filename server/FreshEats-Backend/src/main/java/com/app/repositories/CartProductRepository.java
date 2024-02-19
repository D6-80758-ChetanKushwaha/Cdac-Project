package com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CartEntity;
import com.app.entities.CartProductEntity;

public interface CartProductRepository extends JpaRepository<CartProductEntity, Long> {
    Optional<CartProductEntity> findByCartIdAndProductId(long cartId, long productId);

    List<CartProductEntity> findByCartId(long cartId);

}
