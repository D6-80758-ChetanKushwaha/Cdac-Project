package com.app.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.CartEntity;
import com.app.entities.CartStatus;

import java.util.Optional;


@Repository
@Transactional
public interface CartRepository extends JpaRepository<CartEntity, Long> {

	Optional<CartEntity> findByCustomerIdAndCartStatus(Long customerId, CartStatus status);



}
