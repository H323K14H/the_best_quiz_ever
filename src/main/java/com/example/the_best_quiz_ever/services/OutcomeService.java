package com.example.the_best_quiz_ever.services;

import com.example.the_best_quiz_ever.repositories.OutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutcomeService {
    @Autowired
    OutcomeRepository outcomeRepository;

}
