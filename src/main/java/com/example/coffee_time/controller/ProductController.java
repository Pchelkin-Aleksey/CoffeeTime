package com.example.coffee_time.controller;

import com.example.coffee_time.dto.ProductDto;
import com.example.coffee_time.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product")
    public String getProduct(Model model){
        List<ProductDto> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "/product/list";
    }

    @GetMapping("/product/new")
    public String createProduct(){
        return "/product/form";
    }

    @GetMapping(value = "/product/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        ProductDto product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/form";
    }

    @PostMapping(value = "/save")
    public String saveProduct(ProductDto productDTO) {
        productService.saveProduct(productDTO);
        return "redirect:/product";
    }

    @GetMapping(value = "/product/{id}/delete")
    public String deleteProduct(ProductDto productDTO) {
        productService.delete(productDTO);
        return "redirect:/product";
    }
}
