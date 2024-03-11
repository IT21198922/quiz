package com.example.demoquizapp.service;

import com.example.demoquizapp.dto.CreateCategoryRequest;
import com.example.demoquizapp.model.Category;

public interface CategoryService {
    Category create(CreateCategoryRequest request);
}
