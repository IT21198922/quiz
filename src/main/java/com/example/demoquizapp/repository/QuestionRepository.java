package com.example.demoquizapp.repository;

import com.example.demoquizapp.model.Category;
import com.example.demoquizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByCategory(Category category);
}
