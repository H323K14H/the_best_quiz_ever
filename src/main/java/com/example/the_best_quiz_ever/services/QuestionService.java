package com.example.the_best_quiz_ever.services;

import com.example.the_best_quiz_ever.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

}
