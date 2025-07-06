package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductDto getProduct(Long id);

    ProductDto createProduct(ProductDto productDto);
}
