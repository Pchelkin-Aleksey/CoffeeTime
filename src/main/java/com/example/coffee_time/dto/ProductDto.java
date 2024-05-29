package com.example.coffee_time.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private String description;
}