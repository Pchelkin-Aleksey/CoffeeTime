package com.example.coffee_time.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;

    public ProductDto(String name, String description){
        this.name = name;
        this.description = description;
    }

}