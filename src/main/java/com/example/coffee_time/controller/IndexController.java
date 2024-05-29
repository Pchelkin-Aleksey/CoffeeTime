package com.example.coffee_time.controller;

import com.example.coffee_time.entity.Product;
import com.example.coffee_time.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/")
    public String getIndex(){
        return "product/form";
    }

    @GetMapping("/list")
    public ModelAndView getList(){
        ModelAndView mav = new ModelAndView("product/list");
        mav.addObject("products", productRepository.findAll());
        return mav;
    }

}
