package com.app.services;

import java.util.List;


import com.app.dtos.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getAllCategories();

	CategoryDTO getCategoryById(Long id);

	List<CategoryDTO> getCategoriesByCategoryName(String categoryName);

	CategoryDTO addCategory(CategoryDTO category);

	void deleteCategory(Long categoryId);

	CategoryDTO updateCategory(Long categoryId, CategoryDTO updatedCategory);

}
