package com.example.the_best_quiz_ever.services;

import com.example.the_best_quiz_ever.model_DTOs.OutcomeDTO;
import com.example.the_best_quiz_ever.models.Answer;
import com.example.the_best_quiz_ever.models.Outcome;
import com.example.the_best_quiz_ever.models.Question;
import com.example.the_best_quiz_ever.models.Quiz;
import com.example.the_best_quiz_ever.model_DTOs.Reply;
import com.example.the_best_quiz_ever.repositories.AnswerRepository;
import com.example.the_best_quiz_ever.repositories.OutcomeRepository;
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
    OutcomeRepository outcomeRepository;

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
        Reply reply = new Reply(q1, null);
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
             Outcome finalOutcome = processOutcome(selectedOptions);
             OutcomeDTO finalResult = new OutcomeDTO(finalOutcome.getOutcome());
             Reply reply = new Reply(null, finalResult);
             return reply;
        }

        quiz.setCurrentQuestion(quiz.getCurrentQuestion() + 1);
        quizRepository.save(quiz);

//        return currentQ = nextQ
        Question nextQ = questionRepository.findById(quiz.getCurrentQuestion()).get();
        return new Reply(nextQ, null);
    }

//    method - tally results and print outcome

    public Outcome processOutcome(List<Long> selectedOption){
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

//      count for each outcome
        for (Long outcomeId: selectedOption) {
            if (outcomeId == 1){
              count1 += 1;
            }
                else if (outcomeId == 2){
              count2 += 1;
            }
                else if (outcomeId == 3){
              count3 += 1;
            }
                else if (outcomeId == 4){
              count4 += 1;
            }

        }

        int modeCount = count1;
        Long modeId = 1L;
        if (count2 > modeCount){
            modeCount = count2;
             modeId = 2L;
        }

        if (count3 > modeCount){
            modeCount = count3;
            modeId = 3L;
        }

        if (count4 > modeCount){
            modeCount = count4;
            modeId = 4L;
        }

        return outcomeRepository.findById(modeId).get();
    }


}
