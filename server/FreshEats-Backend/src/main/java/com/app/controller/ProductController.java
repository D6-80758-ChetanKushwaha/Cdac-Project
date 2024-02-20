package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.ProductDTO;
import com.app.services.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// public ProductController(ProductService productService) {
	// this.productService = productService;
	// }

	@GetMapping("/search")
	public ResponseEntity<List<ProductDTO>> searchProducts(@RequestParam String keyword) {
		List<ProductDTO> products = productService.searchByKeyword(keyword);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/get")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		System.out.println("get request got");
		List<ProductDTO> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		// Product product = productService.getProductById(id);
		return new ResponseEntity<ProductDTO>(productService.getProductById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productdto) {
		ProductDTO savedProduct = productService.save(productdto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productdto) {
		// ProductDTO updatedProduct = productService.updateProduct(id, productdto);
		return new ResponseEntity<ProductDTO>(productService.updateProduct(id, productdto), HttpStatus.OK);

		// if (updatedProduct != null) {
		// return ResponseEntity.ok(updatedProduct);
		// } else {
		// return ResponseEntity.notFound().build();
		// }
	}

	@DeleteMapping("/{productId}")
	public void deleteproduct(@PathVariable Long productId) {
		productService.deleteProduct(productId);
	}

	// @GetMapping("/byPriceRange")
	// public ResponseEntity<List<ProductDTO>> getProductsByPriceRange(@RequestParam
	// double minPrice, @RequestParam double maxPrice) {
	// List<ProductDTO> products = productService.getProductsByPriceRange(minPrice,
	// maxPrice);
	// return new ResponseEntity<>(products, HttpStatus.OK);
	// }

	// @GetMapping("/withValidDiscount")
	// public ResponseEntity<List<ProductDTO>> getProductsWithValidDiscount() {
	// List<ProductDTO> products = productService.getProductsWithValidDiscount();
	// return new ResponseEntity<>(products, HttpStatus.OK);
	// }

}
