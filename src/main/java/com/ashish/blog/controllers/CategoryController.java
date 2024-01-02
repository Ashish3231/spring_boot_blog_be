package com.ashish.blog.controllers;

import com.ashish.blog.payloads.ApiResponse;
import com.ashish.blog.payloads.CategoryDto;
import com.ashish.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Create Category
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody  CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return ResponseEntity.ok(createCategory);
    }

    //update category
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
        CategoryDto updateCategoryDto = this.categoryService.updateCategory(categoryDto, categoryId);
        return ResponseEntity.ok(updateCategoryDto);
    }

    //Get Category
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
        CategoryDto categoryDto = this.categoryService.getCategory(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    //get All Category
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> categoryDtoList = this.categoryService.getAllCategory();
        return ResponseEntity.ok(categoryDtoList);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse> (new ApiResponse("Delete Category of category_id: "+ categoryId,true), HttpStatus.CREATED);
    }
}
