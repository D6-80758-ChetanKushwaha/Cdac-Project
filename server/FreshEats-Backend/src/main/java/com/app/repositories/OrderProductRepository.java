package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.OrderProductEntity;

public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long> {
    
}
