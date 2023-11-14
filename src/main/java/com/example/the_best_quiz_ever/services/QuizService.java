package com.example.the_best_quiz_ever.services;

import com.example.the_best_quiz_ever.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    private ArrayList<String> selectedOptions;
    
    
}
