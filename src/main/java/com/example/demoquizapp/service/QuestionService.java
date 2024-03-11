package com.example.demoquizapp.service;

import com.example.demoquizapp.dto.CreateQuestionRequest;
import com.example.demoquizapp.dto.CreateQuestionResponse;

import java.util.List;

public interface QuestionService {
    CreateQuestionResponse create(CreateQuestionRequest request, Long categoryId);

    List<CreateQuestionResponse> getCategoryQuestion(Long categoryId);

    List<CreateQuestionResponse> getRandomQuestions();


}
