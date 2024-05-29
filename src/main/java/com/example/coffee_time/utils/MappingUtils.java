package com.example.coffee_time.utils;

import com.example.coffee_time.dto.ProductDto;
import com.example.coffee_time.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    public ProductDto mapToProductDto(Product productEntity){
        ProductDto dto = new ProductDto();
        dto.setId(productEntity.getId());
        dto.setTitle(productEntity.getTitle());
        dto.setDescription(productEntity.getDescription());
        return dto;
    }

    public Product mapToProductEntity(ProductDto dto){
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
