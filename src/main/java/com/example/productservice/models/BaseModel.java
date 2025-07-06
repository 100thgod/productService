package com.example.productservice.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private String createdBy;
    private String lastUpdatedBy;
    private boolean isDeleted;
}
