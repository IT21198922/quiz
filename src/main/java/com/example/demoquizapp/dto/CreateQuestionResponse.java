package com.example.demoquizapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateQuestionResponse {
    private Long id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;
    private String category;
}
