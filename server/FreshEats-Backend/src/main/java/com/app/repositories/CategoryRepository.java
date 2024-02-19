package com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CategoryEntity;



public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	Optional<CategoryEntity> findByCategoryName(String categoryName);
	
	//List<CategoryEntity> findByCategoryName(String categoryName);



}
