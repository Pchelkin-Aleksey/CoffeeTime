package com.example.coffee_time.utils;

import com.example.coffee_time.dto.ProductDto;
import com.example.coffee_time.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    public ProductDto mapToProductDto(Product entity){
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Product mapToProductEntity(ProductDto dto){
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
