package com.example.productservice.controller;

import com.example.productservice.convertor.ProductDtoConvertor;
import com.example.productservice.dto.ProductRequestDto;
import com.example.productservice.dto.ProductResponseDto;
import com.example.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        List<ProductResponseDto>   productResponseDtos  = new ArrayList<>();
        productService.getAllProducts().forEach(product -> productResponseDtos.add(ProductDtoConvertor.convertProductToProductResponseDto(product)));
        return new ResponseEntity<>(productResponseDtos,  HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long id){
        return new ResponseEntity<>(ProductDtoConvertor.convertProductToProductResponseDto(productService.getProduct(id)), HttpStatus.OK );
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto product){

        return new ResponseEntity<>(ProductDtoConvertor.convertProductToProductResponseDto(productService.createProduct(ProductDtoConvertor.convertProductRequestDtoToProduct(product))), HttpStatus.CREATED);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody ProductRequestDto product ,  @PathVariable Long id){
        return new ResponseEntity<>(ProductDtoConvertor.convertProductToProductResponseDto(productService.updateProduct(ProductDtoConvertor.convertProductRequestDtoToProduct(product),id)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> replaceProduct(@RequestBody ProductRequestDto product, @PathVariable Long id){

        return new ResponseEntity<>(ProductDtoConvertor.convertProductToProductResponseDto(productService.replaceProduct(ProductDtoConvertor.convertProductRequestDtoToProduct(product), id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(ProductDtoConvertor.convertProductToProductResponseDto(productService.deleteProduct(id)), HttpStatus.OK);
    }
}
