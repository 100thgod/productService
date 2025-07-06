package com.example.productservice.service.impl;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.models.Product;
import com.example.productservice.service.ProductService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductServiceFakeStoreImpl implements ProductService {
    RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<ProductDto> getAllProducts() {
        ResponseEntity<List<ProductDto>> response = restTemplate.exchange(
            "https://fakestoreapi.com/products",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<ProductDto>>() {}
        );
        return response.getBody();
    }

    @Override
    public ProductDto getProduct(Long id) {
        return restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, ProductDto.class).getBody();
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        ResponseEntity<ProductDto> response = restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, ProductDto.class);
        return response.getBody();
    }
}
