package com.example.demoquizapp.service.impl;

import com.example.demoquizapp.dto.CreateCategoryRequest;
import com.example.demoquizapp.model.Category;
import com.example.demoquizapp.repository.CategoryRepository;
import com.example.demoquizapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category create(CreateCategoryRequest request) {

        Category category = new Category();
        BeanUtils.copyProperties(request,category);

        return categoryRepository.save(category);
    }
}
