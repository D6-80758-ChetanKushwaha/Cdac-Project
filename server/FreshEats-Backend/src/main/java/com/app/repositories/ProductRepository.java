package com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dtos.ProductDTO;
import com.app.entities.ProductEntity;
import com.app.entities.SellerEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	Optional<ProductEntity> findById(Long productId);
	
	@Query("SELECT p FROM ProductEntity p WHERE lower(p.name) LIKE %:keyword%")
    List<ProductEntity> findByKeyword(@Param("keyword") String keyword);

	//List<ProductDTO> findProductsByMrpPriceBetween(double minPrice, double maxPrice);

	//List<ProductDTO> findProductsWithValidDiscount();

	

}
