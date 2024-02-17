package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CategoryEntity;



public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	List<CategoryEntity> findByCategoryName(String categoryName);

}
