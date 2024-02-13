package com.fresheats.fresh.service;

import com.fresheats.fresh.dao.ProductDao;
import com.fresheats.fresh.dto.ProductCatelogDto;
import com.fresheats.fresh.entities.ProductEntity;
import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpt implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ProductDao productDao;

    @Override
    public List<ProductCatelogDto> getAllProduct() {
        return this.productDao
                .findAll()
                .stream()
                .map((prod -> modelMapper.map(prod, ProductCatelogDto.class)))
                .toList();
    }

    @Override
    public ProductEntity addProduct(ProductEntity product) {

        return this.productDao.save(product);
    }
}
