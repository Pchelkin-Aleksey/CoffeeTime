package com.example.coffee_time.service;

import com.example.coffee_time.dto.ProductDto;
import com.example.coffee_time.entity.Product;
import com.example.coffee_time.repository.ProductRepository;
import com.example.coffee_time.utils.MappingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final String description = "none";

    MappingUtils mappingUtils;
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(mappingUtils::mapToProductDto)
                .collect(Collectors.toList());
    }
    public ProductDto findById(Long id) {
        return  mappingUtils.mapToProductDto(productRepository.findById(id).orElse(new Product()));
    }
    public ProductDto save(Product product) {
        return mappingUtils.mapToProductDto(productRepository.save(product));
    }
    public void delete(Product product) {
        productRepository.delete(product);
    }

    public void Descriptions(List<ProductDto> list){
        list.forEach(productDto ->
                productDto.setDescription(description)
        );
    }
}
