package com.fresheats.fresh.service;

import com.fresheats.fresh.dao.ProductDao;
import com.fresheats.fresh.dto.ProductCatelogDto;
import com.fresheats.fresh.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {
    List<ProductCatelogDto> getAllProduct();

    ProductEntity addProduct(ProductEntity product);

}
