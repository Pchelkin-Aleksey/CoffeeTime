package com.example.coffee_time.utils;

import com.example.coffee_time.dto.ProductDto;
import com.example.coffee_time.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    public ProductDto mapToProductDto(Product productEntity){
        ProductDto dto = new ProductDto();
        dto.setId(productEntity.getId());
        dto.setName(productEntity.getName());
        dto.setDescription(productEntity.getDescription());
        return dto;
    }

    public Product mapToProductEntity(ProductDto dto){
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
