package com.example.productservice.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FakeStoreProductResponseDto {
    private long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;
}
