package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.CategoryDTO;
import com.app.dtos.ProductDTO;
import com.app.entities.CategoryEntity;
import com.app.entities.ProductEntity;
import com.app.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cdao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CategoryDTO> getAllCategories() {

		List<CategoryDTO> list = cdao.findAll().stream().map(m -> mapper.map(m, CategoryDTO.class))
				.collect(Collectors.toList());

		return list;
	}

	@Override
	public CategoryDTO getCategoryById(Long id) {

		CategoryEntity categoryentity = cdao.getReferenceById(id);
		return mapper.map(categoryentity, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getCategoriesByCategoryName(String categoryName) {

//		Optional<CategoryEntity> categoryEntities = cdao.findByCategoryName(categoryName);
//		return categoryEntities.stream()
//				.map(entity -> mapper.map(entity, CategoryDTO.class))
//				.collect(Collectors.toList());
		return null;
	}

	@Override
	public CategoryDTO addCategory(CategoryDTO category) {
		 Optional<CategoryEntity> existingCategory = cdao.findByCategoryName(category.getCategoryName());
	        
	        if (existingCategory.isPresent()) {
	            // Handle the case where the category already exists. Could throw an exception or return null.
	            throw new IllegalStateException("Category already exists");
	            // Or return null; depending on your error handling strategy
	        } else {
		CategoryEntity categoryentity = cdao.save(mapper.map(category, CategoryEntity.class));
		return mapper.map(categoryentity, CategoryDTO.class);
	}
	}

	@Override
	public void deleteCategory(Long categoryId) {
		CategoryEntity c = cdao.findById(categoryId).get();

		if (c != null) {
			cdao.delete(c);
		}
	}

	@Override
	public CategoryDTO updateCategory(Long categoryId, CategoryDTO updatedCategory) {
		CategoryEntity category = cdao.findById(categoryId).orElseThrow(null);
		category.setCategoryName(updatedCategory.getCategoryName());
		category.setDescription(updatedCategory.getDescription());

		cdao.save(category);
		CategoryDTO categorydto = mapper.map(category, CategoryDTO.class);
		return categorydto;

	}

}
