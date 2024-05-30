package com.example.coffee_time.utils;

import com.example.coffee_time.dto.ProductDto;
import com.example.coffee_time.entity.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MappingUtils {

    public List<ProductDto> productEntitytoDTOList(List<Product> products){
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product:products)
            productDtos.add(mapToProductDto(product));

        return productDtos;
    }

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