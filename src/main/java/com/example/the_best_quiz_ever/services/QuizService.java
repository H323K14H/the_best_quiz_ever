package com.example.the_best_quiz_ever.services;

import com.example.the_best_quiz_ever.models.Quiz;
import com.example.the_best_quiz_ever.models.Reply;
import com.example.the_best_quiz_ever.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    private ArrayList<String> selectedOptions;

    public QuizService(){

    }

    public List<Quiz> getAllQuizzes(){
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id){
        return quizRepository.findById(id).get();
    }

//    public Reply startQuiz(){
//
//    }


    
    
}
