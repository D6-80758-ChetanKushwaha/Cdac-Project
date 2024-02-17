package com.app.repositories;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

	Optional<CustomerEntity> findByEmail(String email);

}
