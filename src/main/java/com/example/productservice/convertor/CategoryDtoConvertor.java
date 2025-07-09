package com.example.productservice.convertor;

import com.example.productservice.dto.CategoryRequestDto;
import com.example.productservice.dto.CategoryResponseDto;
import com.example.productservice.models.Category;

public class CategoryDtoConvertor {
    private CategoryDtoConvertor() {

    }
    public static Category convertCategoryRequestDtoToCategory(CategoryRequestDto categoryRequestDto){
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        return category;
    }

    public static Category convertCategoryResponseDtoToCategory(CategoryResponseDto categoryResponseDto){
        Category category = new Category();
        category.setName(categoryResponseDto.getName());
        return category;
    }

    public static CategoryRequestDto convertCategoryToCategoryRequestDto(Category category){
        CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
        categoryRequestDto.setName(category.getName());
        return categoryRequestDto;
    }
    public static CategoryResponseDto convertCategoryToCategoryResponseDto(Category category){
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setName(category.getName());
        return categoryResponseDto;
    }
}
