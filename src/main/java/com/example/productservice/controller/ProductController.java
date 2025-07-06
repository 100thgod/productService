package com.example.productservice.controller;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.models.Product;
import com.example.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// role of DTO should exist till controller.
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),  HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK );
    }

    @PostMapping()
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }
}
