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

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    OutcomeRepository outcomeRepository;

    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        create new quiz
        Quiz quiz1 = new Quiz("Animal Quiz", 1);
        quizRepository.save(quiz1);

//        create questions
        Question q1 = new Question(quiz1, "How are you feeling?", 1);
        questionRepository.save(q1);
        quiz1.addQuestion(q1);

        Question q2 = new Question(quiz1, "How are you feeling?", 2);
        questionRepository.save(q2);
        quiz1.addQuestion(q2);

        Question q3 = new Question(quiz1, "How are you feeling?", 3);
        questionRepository.save(q3);
        quiz1.addQuestion(q3);

        Question q4 = new Question(quiz1, "How are you feeling?", 4);
        questionRepository.save(q4);
        quiz1.addQuestion(q4);

        Question q5 = new Question(quiz1, "How are you feeling?", 7);
        questionRepository.save(q5);
        quiz1.addQuestion(q5);

        Question q6 = new Question(quiz1, "How are you feeling?", 6);
        questionRepository.save(q6);
        quiz1.addQuestion(q6);

        Question q7 = new Question(quiz1, "How are you feeling?", 7);
        questionRepository.save(q7);
        quiz1.addQuestion(q7);

        Question q8 = new Question(quiz1, "How are you feeling?", 8);
        questionRepository.save(q8);
        quiz1.addQuestion(q8);

        Question q9 = new Question(quiz1, "How are you feeling?", 9);
        questionRepository.save(q9);
        quiz1.addQuestion(q9);

        Question q10 = new Question(quiz1, "How are you feeling?", 10);
        questionRepository.save(q10);
        quiz1.addQuestion(q10);

        quizRepository.save(quiz1);

//

        Outcome o1 = new Outcome(quiz1, "Slothhhh");
        outcomeRepository.save(o1);

        Answer a1 = new Answer(q1, o1, "a");
        answerRepository.save(a1);
    }
}
