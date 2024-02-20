package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.SellerEntity;

@Repository
public interface SellerRepository extends  JpaRepository<SellerEntity, Long>{

	//Optional<SellerEntity> findByEmailAndPassword(String email, String password);

	Optional<SellerEntity> findByEmail(String email);

}
