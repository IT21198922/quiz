package com.example.demoquizapp.controller;

import com.example.demoquizapp.dto.CreateQuestionRequest;
import com.example.demoquizapp.dto.CreateQuestionResponse;
import com.example.demoquizapp.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/categories/{category-id}/questions")
    public CreateQuestionResponse create(@RequestBody CreateQuestionRequest request, @PathVariable("category-id") Long categoryId) {
        return questionService.create(request, categoryId);
    }

    @GetMapping("/categories/{category-id}/questions")
    public List<CreateQuestionResponse> get(@PathVariable("category-id") Long categoryId) {
        return questionService.getCategoryQuestion(categoryId);
    }

    @GetMapping("/random")
    public List<CreateQuestionResponse> getRandomQuestions() {
        return questionService.getRandomQuestions();
    }
}
