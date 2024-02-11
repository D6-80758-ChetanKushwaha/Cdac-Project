package com.fresheats.fresh.dao;

import com.fresheats.fresh.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {

}
