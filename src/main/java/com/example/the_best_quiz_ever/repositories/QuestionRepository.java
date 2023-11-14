package com.example.the_best_quiz_ever.repositories;

import com.example.the_best_quiz_ever.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
