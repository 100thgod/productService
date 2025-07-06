package com.example.productservice.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product  extends BaseModel{
    private String name;
    private String description;
    private double price;
    private Category category;
    private String imageURL;

}
