package com.example.productservice.convertor;

import com.example.productservice.dto.ProductRequestDto;
import com.example.productservice.dto.ProductResponseDto;
import com.example.productservice.models.Product;


public class ProductDtoConvertor {

    private ProductDtoConvertor() {

    }

    public static Product convertProductRequestDtoToProduct(ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setId(productRequestDto.getId());
        product.setImageURL(productRequestDto.getImage());
        product.setPrice(productRequestDto.getPrice());
        product.setDescription(productRequestDto.getDescription());
        product.setCategory(CategoryDtoConvertor.convertCategoryRequestDtoToCategory(productRequestDto.getCategory()));
        product.setName(productRequestDto.getTitle());
        return product;
    }

    public static ProductResponseDto convertProductToProductResponseDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setImage(product.getImageURL());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setCategory(CategoryDtoConvertor.convertCategoryToCategoryResponseDto(product.getCategory()));
        productResponseDto.setTitle(product.getName());
        return productResponseDto;
    }

    public static Product convertProductResponseDtoToProduct(ProductResponseDto productResponseDto){
        Product product = new Product();
        product.setId(productResponseDto.getId());
        product.setImageURL(productResponseDto.getImage());
        product.setPrice(productResponseDto.getPrice());
        product.setDescription(productResponseDto.getDescription());
        product.setCategory(CategoryDtoConvertor.convertCategoryResponseDtoToCategory(productResponseDto.getCategory()));
        product.setName(productResponseDto.getTitle());
        return product;
    }

    public static ProductRequestDto convertProductToProductRequestDto(Product product){
        ProductRequestDto productRequestDto = new ProductRequestDto();
        productRequestDto.setId(product.getId());
        productRequestDto.setImage(product.getImageURL());
        productRequestDto.setPrice(product.getPrice());
        productRequestDto.setDescription(product.getDescription());
        productRequestDto.setCategory(CategoryDtoConvertor.convertCategoryToCategoryRequestDto(product.getCategory()));
        productRequestDto.setTitle(product.getName());
        return productRequestDto;
    }

}
