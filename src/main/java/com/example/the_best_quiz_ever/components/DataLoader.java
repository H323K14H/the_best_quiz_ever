package com.example.the_best_quiz_ever.components;

import com.example.the_best_quiz_ever.models.Answer;
import com.example.the_best_quiz_ever.models.Outcome;
import com.example.the_best_quiz_ever.models.Question;
import com.example.the_best_quiz_ever.models.Quiz;
import com.example.the_best_quiz_ever.repositories.AnswerRepository;
import com.example.the_best_quiz_ever.repositories.OutcomeRepository;
import com.example.the_best_quiz_ever.repositories.QuestionRepository;
import com.example.the_best_quiz_ever.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    QuizRepository quizRepository;

//    @Autowired
//    QuestionRepository questionRepository;
//
//    @Autowired
//    AnswerRepository answerRepository;
//
//    @Autowired
//    OutcomeRepository outcomeRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Quiz quiz1 = new Quiz("Animal quizz", 1);
        quizRepository.save(quiz1);
//        Question q1 = new Question();
//        Answer a1 = new Answer();
//        Outcome o1 = new Outcome();
    }
}
