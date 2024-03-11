package com.example.demoquizapp.controller;

import com.example.demoquizapp.dto.CreateCategoryRequest;
import com.example.demoquizapp.model.Category;
import com.example.demoquizapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/categories")
    public Category create(@RequestBody CreateCategoryRequest request){
        return categoryService.create(request);
    }
}
