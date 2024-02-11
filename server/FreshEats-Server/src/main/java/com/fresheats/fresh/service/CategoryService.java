package com.fresheats.fresh.service;

import com.fresheats.fresh.entities.CategoryEntity;
import com.fresheats.fresh.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {
    List<CategoryEntity> getAllCategory();
    CategoryEntity addCategory(CategoryEntity category);
}
