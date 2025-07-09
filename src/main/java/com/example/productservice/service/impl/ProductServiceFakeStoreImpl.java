package com.example.productservice.service.impl;

import com.example.productservice.client.FakeStoreClient;
import com.example.productservice.convertor.FakeStoreProductDtoConverter;
import com.example.productservice.models.Product;
import com.example.productservice.service.ProductService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceFakeStoreImpl implements ProductService {

    FakeStoreClient fakeStoreClient;

    public ProductServiceFakeStoreImpl(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        fakeStoreClient.getAllProducts().forEach(fakeStoreProductResponseDto -> products.add(FakeStoreProductDtoConverter.convertFakeStoreProductResponseDtoToProduct(fakeStoreProductResponseDto)));
        return products;
    }

    @Override
    public Product getProduct(Long id) {
        return FakeStoreProductDtoConverter.convertFakeStoreProductResponseDtoToProduct(fakeStoreClient.getProduct(id));
    }


    public Product createProduct(Product product) {
        return FakeStoreProductDtoConverter.convertFakeStoreProductResponseDtoToProduct(
                fakeStoreClient.createProduct(
                        FakeStoreProductDtoConverter.convertProductToFakeStoreProductRequestDto(product)
                ));
    }

    @Override
    public Product deleteProduct(Long id) {
        return FakeStoreProductDtoConverter.convertFakeStoreProductResponseDtoToProduct(fakeStoreClient.deleteProduct(id));
    }

    @Override
    public Product replaceProduct(Product product, Long id) {
        return FakeStoreProductDtoConverter.convertFakeStoreProductResponseDtoToProduct(
                fakeStoreClient.replaceProduct(
                        FakeStoreProductDtoConverter.convertProductToFakeStoreProductRequestDto(product), id));
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        return FakeStoreProductDtoConverter.convertFakeStoreProductResponseDtoToProduct(
                fakeStoreClient.updateProduct(
                        FakeStoreProductDtoConverter.convertProductToFakeStoreProductRequestDto(product), id));
    }


}
