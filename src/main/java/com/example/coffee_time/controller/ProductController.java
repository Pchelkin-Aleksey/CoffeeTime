package com.example.coffee_time.controller;

import com.example.coffee_time.dto.ProductDto;
import com.example.coffee_time.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @GetMapping("/product")
    public String getProduct(){
        return "/product/form";
    }

    @PostMapping("/save")
    public String saveProduct(@RequestParam String name,@RequestParam String description){
        ProductDto productDto = new ProductDto( name, description);

        return "/product/list";
    }

}
