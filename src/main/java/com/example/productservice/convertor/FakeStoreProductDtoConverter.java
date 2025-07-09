package com.example.productservice.convertor;

import com.example.productservice.dto.FakeStoreProductRequestDto;
import com.example.productservice.dto.FakeStoreProductResponseDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;

public class FakeStoreProductDtoConverter {

    private FakeStoreProductDtoConverter() {

    }

    public static Product convertFakeStoreProductToProduct(FakeStoreProductRequestDto productRequestDto){
        Product product = new Product();
        product.setId(productRequestDto.getId());
        product.setImageURL(productRequestDto.getImage());
        product.setPrice(productRequestDto.getPrice());
        product.setDescription(productRequestDto.getDescription());
        Category category = new Category();
        category.setName(productRequestDto.getCategory());
        product.setCategory(category);
        product.setName(productRequestDto.getTitle());
        return product;
    }

    public static FakeStoreProductResponseDto convertProductToFakeStoreProductResponseDto(Product product){
        FakeStoreProductResponseDto productResponseDto = new FakeStoreProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setImage(product.getImageURL());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setCategory(product.getCategory().getName());
        productResponseDto.setTitle(product.getName());
        return productResponseDto;
    }

    public static Product convertFakeStoreProductResponseDtoToProduct(FakeStoreProductResponseDto productResponseDto){
        Product product = new Product();
        product.setId(productResponseDto.getId());
        product.setImageURL(productResponseDto.getImage());
        product.setPrice(productResponseDto.getPrice());
        product.setDescription(productResponseDto.getDescription());
        Category category = new Category();
        category.setName(productResponseDto.getCategory());
        product.setCategory(category);
        product.setName(productResponseDto.getTitle());
        return product;
    }

    public static FakeStoreProductRequestDto convertProductToFakeStoreProductRequestDto(Product product){
        FakeStoreProductRequestDto productRequestDto = new FakeStoreProductRequestDto();
        productRequestDto.setId(product.getId());
        productRequestDto.setImage(product.getImageURL());
        productRequestDto.setPrice(product.getPrice());
        productRequestDto.setDescription(product.getDescription());
        productRequestDto.setCategory(product.getCategory().getName());
        productRequestDto.setTitle(product.getName());
        return productRequestDto;
    }

}
