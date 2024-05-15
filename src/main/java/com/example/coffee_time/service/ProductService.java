package com.example.coffee_time.service;

import com.example.coffee_time.entity.Product;
import com.example.coffee_time.repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product save(Product product) {
        return productRepository.save(product);
    }
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
