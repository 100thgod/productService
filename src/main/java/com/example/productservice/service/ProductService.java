package com.example.productservice.service;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(Long id);

    Product createProduct(Product product);

    Product deleteProduct(Long id);

    Product replaceProduct(Product product, Long id);

    Product updateProduct(Product product, Long id);
}
