package com.example.coffee_time.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/")
    public String getProduct(){
        return "templates/product/list.html";
    }

    @GetMapping("/new")
    public String getProductNew(){
        return "templates/product/form.html";
    }

    @GetMapping("/{id}")
    public void getNewProduct(){
        return ;
    }

    @PostMapping("/save")
    public void save(){
    }

    @GetMapping("/{id}/delete")
    public void delete(){
        return ;
    }

}
