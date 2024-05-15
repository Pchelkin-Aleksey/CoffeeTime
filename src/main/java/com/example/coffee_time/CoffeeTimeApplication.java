package com.example.coffee_time;

import com.example.coffee_time.entity.Product;
import com.example.coffee_time.repository.ProductRepository;
import com.example.coffee_time.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CoffeeTimeApplication implements CommandLineRunner {
    private final ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(CoffeeTimeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setName("Test1");
        productService.save(product);

        Product product1 = new Product();
        product1.setName("Test2");
        productService.save(product1);
        System.out.println(productService.findAll());

        Long product1GetId = product1.getId();
        Product getProduct = productService.findById(product1GetId);
        productService.save(getProduct);
        System.out.println(productService.findAll());

        productService.delete(getProduct);
        System.out.println(productService.findAll());
    }
}
