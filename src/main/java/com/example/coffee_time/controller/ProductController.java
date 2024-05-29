package com.example.coffee_time.controller;

import com.example.coffee_time.dto.ProductDto;
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
    public String saveProduct(@RequestParam String title, @RequestParam String description){
        //ProductDto productDto = new ProductDto(name, description);
        Product product = new Product();
        product.setTitle(title);

        product.setDescription(description);
        productService.save(product);
        return "/product/list";
    }
}
