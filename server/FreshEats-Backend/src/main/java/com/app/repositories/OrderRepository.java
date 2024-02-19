package com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import com.app.dtos.OrderDTO;
import com.app.entities.OrderEntity;

public interface OrderRepository extends JpaRepository< OrderEntity, Long>{

	List<OrderEntity> findByCustomerId(long customerId);

	

}
