package com.fresheats.fresh.controller;

import com.fresheats.fresh.entities.ProductEntity;
import com.fresheats.fresh.entities.UserEntity;
import com.fresheats.fresh.service.ProductService;
import com.fresheats.fresh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;
    @GetMapping({"/home","/"})
    public List<ProductEntity> home(){
        return this.productService.getAllProduct();
    }
    @PostMapping({"/addUser"})
    public UserEntity addUser(@RequestBody UserEntity user){

        return this.userService.addUser(user);
    }
}
