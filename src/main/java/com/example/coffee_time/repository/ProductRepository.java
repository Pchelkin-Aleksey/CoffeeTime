package com.example.coffee_time.repository;

import com.example.coffee_time.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
