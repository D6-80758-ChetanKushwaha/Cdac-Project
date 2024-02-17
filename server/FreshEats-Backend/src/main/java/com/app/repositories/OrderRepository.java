package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dtos.OrderDTO;
import com.app.entities.OrderEntity;

public interface OrderRepository extends JpaRepository< OrderEntity, Long>{

	

}
