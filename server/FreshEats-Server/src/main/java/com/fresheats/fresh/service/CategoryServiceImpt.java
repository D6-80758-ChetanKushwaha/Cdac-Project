package com.fresheats.fresh.service;

import com.fresheats.fresh.dao.CategoryDao;
import com.fresheats.fresh.entities.CategoryEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpt implements CategoryService{

    @Autowired
    CategoryDao categoryDao;
    @Override
    public List<CategoryEntity> getAllCategory() {
        return this.categoryDao.findAll();
    }

    @Override
    public CategoryEntity addCategory(CategoryEntity category) {
        return this.categoryDao.save(category);
    }
}
