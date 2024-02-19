package com.app.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.ApiResponse;
import com.app.dtos.ProductDTO;
import com.app.entities.CategoryEntity;
import com.app.entities.ProductEntity;
import com.app.exceptions.ProductException;
import com.app.repositories.CategoryRepository;
import com.app.repositories.ProductRepository;
import com.app.repositories.SellerRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository pdao;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private CategoryRepository categoryRepository;
	

	@Override
	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> list = pdao.findAll().stream().map(m -> mapper.map(m, ProductDTO.class))
				.collect(Collectors.toList());

		return list;
	}

	@Override
	public ProductDTO getProductById(Long id) {
		// return pdao.findById(id).get();
		ProductEntity productEntity = pdao.findById(id).orElseThrow();
		return mapper.map(productEntity, ProductDTO.class);
		// return null;
	}

	@Override
	public ProductDTO saveProduct(ProductDTO product) {
		
		ProductEntity prod =  mapper.map(product, ProductEntity.class);
		
		Optional<CategoryEntity> category = categoryRepository.findById(product.getCategoryId());
		// getting category by ID
		if(category.isPresent()) { // checking if present
//			prod.setCategoryId(category.get());
			pdao.save(prod);
			return mapper.map(product, ProductDTO.class);
		}
		else return null; // 
		// setting category in product
		
	}

	@Override
	public ProductDTO updateProduct(Long id, ProductDTO product) {
		ProductEntity prod = pdao.findById(id).orElseThrow(null);
		prod.setName(product.getName());
		prod.setStockQuantity(product.getStockQuantity());
		prod.setProductDescription(product.getProductDescription());
		prod.setProductPrice(product.getProductPrice());
		prod.setImageUrl(product.getImageUrl());
		prod.setDiscountedPrice(product.getDiscountedPrice());
		prod.setDiscountedPercent(product.getDiscountedPercent());
		pdao.save(prod);
		ProductDTO productdto = mapper.map(prod, ProductDTO.class);
		return productdto;

	}

	@Override
	public void deleteProduct(Long productId) {
		ProductEntity p = pdao.findById(productId).get();

		if (p != null) {
			pdao.delete(p);
		}

	}

	@Override
	public List<ProductDTO> searchByKeyword(String keyword) {
		List<ProductEntity> prod = pdao.findByKeyword(keyword.toLowerCase());
		return prod.stream()
				.map(entity -> mapper.map(entity, ProductDTO.class))
				.collect(Collectors.toList());
	}

	// @Override
	// public List<ProductDTO> getProductsByPriceRange(double minPrice, double
	// maxPrice) {
	//
	// return pdao.findProductsByMrpPriceBetween(minPrice, maxPrice);
	//
	// }

	// @Override
	// public List<ProductDTO> getProductsWithValidDiscount() {
	// // TODO Auto-generated method stub
	// //List<ProductEntity> products = pdao.findProductsWithValidDiscount();
	//
	// List<ProductDTO> productDTOs = pdao.findProductsWithValidDiscount().stream()
	// .map(product -> mapper.map(product, ProductDTO.class))
	// .collect(Collectors.toList());
	//
	// return productDTOs;
	// }

}
