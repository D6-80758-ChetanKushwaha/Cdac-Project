package com.fresheats.fresh.controller;

import com.fresheats.fresh.entities.ProductEntity;
import com.fresheats.fresh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    ProductService productService;
    @GetMapping({"/home","/"})
    public List<ProductEntity> home(){

        return this.productService.getAllProduct();
    }
}
