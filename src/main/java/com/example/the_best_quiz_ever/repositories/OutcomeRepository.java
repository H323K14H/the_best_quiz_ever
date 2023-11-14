package com.example.the_best_quiz_ever.repositories;

import com.example.the_best_quiz_ever.models.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeRepository extends JpaRepository<Outcome, Long> {
}
