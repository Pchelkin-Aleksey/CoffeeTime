package com.example.coffee_time.controller;

import com.example.coffee_time.entity.Product;
import com.example.coffee_time.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product")
    public String getProduct(){
        return "/product/form";
    }

    @PostMapping("/save")
    public String saveProduct(@RequestParam String name,@RequestParam String description){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        productService.save(product);
        return "/product/list";
    }

}
