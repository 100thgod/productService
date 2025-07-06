package com.example.productservice.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel {
    private String name;
    private String description;
    private List<Product> products;
}
