package com.fresheats.fresh.controller;

import com.fresheats.fresh.entities.CategoryEntity;
import com.fresheats.fresh.entities.ProductEntity;
import com.fresheats.fresh.service.CategoryService;
import com.fresheats.fresh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@ResponseBody
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @PostMapping({"/addProduct"})
    public ProductEntity addProduct(@RequestBody ProductEntity product){

        return this.productService.addProduct(product);
    }

    @PostMapping({"/addCategory"})
    public CategoryEntity addCategory(@RequestBody CategoryEntity category){
        return this.categoryService.addCategory(category);
    }
}
