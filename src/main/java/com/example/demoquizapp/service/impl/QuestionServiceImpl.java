package com.example.demoquizapp.service.impl;

import com.example.demoquizapp.dto.CreateQuestionRequest;
import com.example.demoquizapp.dto.CreateQuestionResponse;
import com.example.demoquizapp.model.Category;
import com.example.demoquizapp.model.Question;
import com.example.demoquizapp.repository.CategoryRepository;
import com.example.demoquizapp.repository.QuestionRepository;
import com.example.demoquizapp.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public CreateQuestionResponse create(CreateQuestionRequest request, Long categoryId) {

        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();

            Question question = new Question();
            BeanUtils.copyProperties(request, question);

            question.setCategory(category);

            questionRepository.save(question);
        }

        return null;
    }

    @Override
    public List<CreateQuestionResponse> getCategoryQuestion(Long categoryId) {

        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();

            List<Question> questions = questionRepository.findByCategory(category);

            return questions.stream()
                    .map(question -> CreateQuestionResponse.builder()
                            .id(question.getId())
                            .question(question.getQuestion())
                            .option1(question.getOption1())
                            .option2(question.getOption2())
                            .option3(question.getOption3())
                            .option4(question.getOption4())
                            .correctAnswer(question.getCorrectAnswer())
                            .category(question.getCategory().getCategory())
                            .build())
                    .toList();
        }

        return null;
    }

    @Override
    public List<CreateQuestionResponse> getRandomQuestions() {
        List<Question> allQuestions = questionRepository.findAll();

        Collections.shuffle(allQuestions);

        List<Question> selectedQuestions = allQuestions.stream()
                .limit(10)
                .toList();

        return selectedQuestions.stream()
                .map(question -> CreateQuestionResponse.builder()
                        .id(question.getId())
                        .question(question.getQuestion())
                        .option1(question.getOption1())
                        .option2(question.getOption2())
                        .option3(question.getOption3())
                        .option4(question.getOption4())
                        .correctAnswer(question.getCorrectAnswer())
                        .category(question.getCategory().getCategory())
                        .build())
                .collect(Collectors.toList());
    }
}
