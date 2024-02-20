package com.fresheats.fresh.dao;

import com.fresheats.fresh.entities.ProductEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductDao extends JpaRepository<ProductEntity, Long> {

}
