package com.example.the_best_quiz_ever.repositories;

import com.example.the_best_quiz_ever.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
