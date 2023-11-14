package com.example.the_best_quiz_ever.repositories;

import com.example.the_best_quiz_ever.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
