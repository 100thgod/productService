package com.example.productservice.client;

import com.example.productservice.dto.FakeStoreProductRequestDto;
import com.example.productservice.dto.FakeStoreProductResponseDto;
import com.example.productservice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreClient {

    RestTemplateBuilder restTemplateBuilder ;
    private static final String baseFakeStoreUrl = "https://fakestoreapi.com/products";
    @Autowired
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    public List<FakeStoreProductResponseDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto[]> response = restTemplate.getForEntity(baseFakeStoreUrl,FakeStoreProductResponseDto[].class );
        FakeStoreProductResponseDto[] body = response.getBody();
        return body != null ? Arrays.stream(body).toList() : List.of();
    }

    public FakeStoreProductResponseDto getProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto> response =  restTemplate.getForEntity(baseFakeStoreUrl + "/{id}", FakeStoreProductResponseDto.class, id);
        if(response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        }else  {
            throw new NotFoundException("Product with id " + id + " not found");
        }
    }

    public FakeStoreProductResponseDto createProduct(FakeStoreProductRequestDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.postForEntity(baseFakeStoreUrl, product , FakeStoreProductResponseDto.class).getBody();

    }

    public FakeStoreProductResponseDto deleteProduct(Long id) {

        ResponseEntity<FakeStoreProductResponseDto> response =  requestForEntity(HttpMethod.DELETE, baseFakeStoreUrl + "/{id}" ,null ,FakeStoreProductResponseDto.class, id);
        if(response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        }else  {
            throw new NotFoundException("Product with id " + id + " not found");
        }
    }

    private  <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }


    public FakeStoreProductResponseDto replaceProduct(FakeStoreProductRequestDto fakeStoreProductRequestDto, Long id) {

        ResponseEntity<FakeStoreProductResponseDto> response =  requestForEntity(HttpMethod.PUT, baseFakeStoreUrl + "/{id}" ,fakeStoreProductRequestDto ,FakeStoreProductResponseDto.class, id);
        if(response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        }else  {
            throw new NotFoundException("Product with id " + id + " not found");
        }
    }

    public FakeStoreProductResponseDto updateProduct(FakeStoreProductRequestDto fakeStoreProductRequestDto, Long id) {
        ResponseEntity<FakeStoreProductResponseDto> response =  requestForEntity(HttpMethod.PATCH, baseFakeStoreUrl + "/{id}" ,fakeStoreProductRequestDto ,FakeStoreProductResponseDto.class, id);
        if(response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        }else  {
            throw new NotFoundException("Product with id " + id + " not found");
        }
    }
}
