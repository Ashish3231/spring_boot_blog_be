package com.ashish.blog.services;

import com.ashish.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDto createCategory (CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //Get Category
    CategoryDto getCategory(Integer categoryId);

    //Get All Categories
    List<CategoryDto> getAllCategory();

    //Delete Category
    void deleteCategory(Integer categoryId);
}
