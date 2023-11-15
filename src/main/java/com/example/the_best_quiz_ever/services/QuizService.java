package com.example.the_best_quiz_ever.services;

import com.example.the_best_quiz_ever.models.Answer;
import com.example.the_best_quiz_ever.models.Outcome;
import com.example.the_best_quiz_ever.models.Question;
import com.example.the_best_quiz_ever.models.Quiz;
import com.example.the_best_quiz_ever.model_DTOs.Reply;
import com.example.the_best_quiz_ever.repositories.AnswerRepository;
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

    @Autowired
    AnswerRepository answerRepository;

    private ArrayList<Long> selectedOptions = new ArrayList<>();

    public QuizService() {

    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).get();
    }


    public Reply startQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id).get();
        long q1_id = 1;
        Question q1 = questionRepository.findById(q1_id).get();
        Reply reply = new Reply(q1);
        return reply;
    }

    public Reply processAnswer(Long answerId, Long qNumber, Long quizId) {

//        Get the quiz id, which brings the first Q
        Quiz quiz = quizRepository.findById(quizId).get();

//        Save the outcome id to selectedOptions ArrayList.
        Answer answer = answerRepository.findById(answerId).get();
        Outcome outcome = answer.getOutcome();
        Long outcomeId = outcome.getId();
        selectedOptions.add(outcomeId);

//        increment current question.

        if (quiz.getCurrentQuestion() > 9) {
             return null;
        }

        quiz.setCurrentQuestion(quiz.getCurrentQuestion() + 1);
        quizRepository.save(quiz);

//        return currentQ = nextQ
        Question nextQ = questionRepository.findById(quiz.getCurrentQuestion()).get();
        return new Reply(nextQ);
    }


}
