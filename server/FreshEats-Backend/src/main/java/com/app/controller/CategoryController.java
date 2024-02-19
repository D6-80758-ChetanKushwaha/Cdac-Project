package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.CategoryDTO;
import com.app.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryservice;
	
	@GetMapping("/get")
	public ResponseEntity<List<CategoryDTO>> getAllCategories() {
		System.out.println("all categories");
		return new ResponseEntity<List<CategoryDTO>>(categoryservice.getAllCategories(), HttpStatus.OK);
	}

	 @GetMapping("/id/{id}")
	    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
	        //Product product = productService.getProductById(id);
			return new ResponseEntity<CategoryDTO>(categoryservice.getCategoryById(id), HttpStatus.OK);
	    }
	 
	 @GetMapping("/name/{categoryName}")
	    public ResponseEntity<List<CategoryDTO>> getCategoriesByCategoryName(@PathVariable String categoryName) {
	        List<CategoryDTO> categories = categoryservice.getCategoriesByCategoryName(categoryName);
	        return new ResponseEntity<>(categories, HttpStatus.OK);
	    }
		
		@PostMapping 
		public ResponseEntity<?> addCategory(@RequestBody CategoryDTO Category) {
			return new ResponseEntity<>( categoryservice.addCategory(Category),HttpStatus.CREATED);
		}
		
		@PutMapping("/{CategoryId}")
		public ResponseEntity<?> updateCategory(@PathVariable Long CategoryId,@RequestBody CategoryDTO updatedCategory) {
			return new ResponseEntity<> (categoryservice.updateCategory(CategoryId, updatedCategory),HttpStatus.OK);
			
		}
		
		@DeleteMapping("/{CategoryId}")
	      public void deleteCategory(@PathVariable Long CategoryId) {
	    	  categoryservice.deleteCategory(CategoryId);
	      }
		
}
