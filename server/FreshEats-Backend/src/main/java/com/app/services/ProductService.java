package com.app.services;

import java.util.List;

import com.app.dtos.ProductDTO;

public interface ProductService {

	List<ProductDTO> getAllProducts();

	ProductDTO saveProduct(ProductDTO product);

	ProductDTO updateProduct(Long id, ProductDTO product);

	ProductDTO getProductById(Long id);

	void deleteProduct(Long productId);

	List<ProductDTO> searchByKeyword(String keyword);

	//List<ProductDTO> getProductsByPriceRange(double minPrice, double maxPrice);

//	List<ProductDTO> getProductsWithValidDiscount();

}
