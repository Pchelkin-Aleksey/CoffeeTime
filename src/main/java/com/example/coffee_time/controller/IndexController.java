package com.example.coffee_time.controller;

import com.example.coffee_time.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/")
    public String getIndex(){
        return "product/form";
    }
}