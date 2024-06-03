package com.example.coffee_time.service;

import com.example.coffee_time.dto.ProductDto;
import com.example.coffee_time.entity.Product;
import com.example.coffee_time.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.coffee_time.utils.MappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final MappingUtils mappingUtils;
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(mappingUtils::mapToProductDto)
                .collect(Collectors.toList());
    }
    public ProductDto findById(Long id) {
        return  mappingUtils.mapToProductDto(productRepository.findById(id).orElse(new Product()));
    }

    public List<ProductDto> findAllProducts() {
        return mappingUtils.productEntitytoDTOList(productRepository.findAll());
    }
    public ProductDto saveProduct(ProductDto product) {
        return mappingUtils.mapToProductDto(productRepository.save(mappingUtils.mapToProductEntity(product)));
    }
    public void delete(ProductDto product) {
        productRepository.delete(mappingUtils.mapToProductEntity(product));
    }

}
