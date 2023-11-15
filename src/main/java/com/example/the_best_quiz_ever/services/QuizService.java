package com.example.the_best_quiz_ever.services;

import com.example.the_best_quiz_ever.models.Question;
import com.example.the_best_quiz_ever.models.Quiz;
import com.example.the_best_quiz_ever.model_DTOs.Reply;
import com.example.the_best_quiz_ever.repositories.QuestionRepository;
import com.example.the_best_quiz_ever.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    private ArrayList<String> selectedOptions;

    public QuizService(){

    }

    public List<Quiz> getAllQuizzes(){
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id){
        return quizRepository.findById(id).get();
    }


    public Reply startQuiz(long id){
        Quiz quiz = quizRepository.findById(id).get();
        long q1_id = 1;
        Question q1 = questionRepository.findById(q1_id).get();
        Reply reply = new Reply(q1);
        return reply;
    }


    
    
}
