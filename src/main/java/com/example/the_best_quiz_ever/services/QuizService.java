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

import java.util.*;

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

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }


    public Reply startQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id).get();
        Long questionId = quiz.findFirstQuestionID();
        Question q1 = questionRepository.findById(questionId).get();
        Reply reply = new Reply(q1, null);
        return reply;
    }

    public Reply processAnswer(Long answerId, Long qNumber, Long quizId) {

//        Get the quiz id, which brings the first Q
        Quiz quiz = quizRepository.findById(quizId).get();

//        Save the outcome id to selectedOptions ArrayList.
        Answer answer = answerRepository.findById(answerId).get();
        Outcome outcome = answer.getOutcome();
        Question targetQuestion = quiz.findQuestionByNumber(qNumber);
        targetQuestion.setOutcome(outcome);
        questionRepository.save(targetQuestion);


//        increment current question.

        if (/*quiz.getCurrentQuestion()*/ qNumber > quiz.getSize() - 1) {
            Outcome finalOutcome = processOutcome(quiz);
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

    public Outcome processOutcome(Quiz quiz) {

        HashMap<Long, Integer> outcomeCounter = new HashMap<>();
        for (Question question : quiz.getAllQuestions()){
            Long currentId = question.getOutcome().getId();
            if (outcomeCounter.containsKey(currentId)){
                outcomeCounter.replace(currentId, outcomeCounter.get(currentId) + 1);
            } else {
                outcomeCounter.put(currentId, 1);
            }
        }

        resetQuiz(quiz);

        Long winningOutcomeId = Collections.max(outcomeCounter.entrySet(), Map.Entry.comparingByValue()).getKey();

        return outcomeRepository.findById(winningOutcomeId).get();

//        Question finalQuestion = questionRepository.findById(qNumber).get(); //get final question = 10
//        Answer answer1 = finalQuestion.getAnswers().get(0); //get a37
//        Answer answer2 = finalQuestion.getAnswers().get(1); //get a38
//        Answer answer3 = finalQuestion.getAnswers().get(2); //get a39
//        Answer answer4 = finalQuestion.getAnswers().get(3); //get a40
//
//        long outcome1Id = answer1.getOutcome().getId();  //get outcome Id for each answer a37 - oucomeid =1 (unless randomized)
//        long outcome2Id = answer2.getOutcome().getId(); //get outcome Id for each answer a38 - oucomeid =2
//        long outcome3Id = answer3.getOutcome().getId(); //get outcome Id for each answer a39 - oucomeid =3
//        long outcome4Id = answer4.getOutcome().getId(); //get outcome Id for each answer a40 - oucomeid =4
//
//        int count1 = 0; //sets all outcome_id counts to 0
//        int count2 = 0;
//        int count3 = 0;
//        int count4 = 0;
//
////      count for each outcome
//        for (Long outcomeId : selectedOption) {
//            if (outcomeId == outcome1Id) {
//                count1 += 1;
//            } else if (outcomeId == outcome2Id) {
//                count2 += 1;
//            } else if (outcomeId == outcome3Id) {
//                count3 += 1;
//            } else if (outcomeId == outcome4Id) {
//                count4 += 1;
//            }
//
//        }
//        Long modeId = outcome1Id;
//        int modeCount = count1;
//
//        if (count2 > modeCount) {
//            modeCount = count2;
//            modeId = outcome2Id;
//        }
//
//        if (count3 > modeCount) {
//            modeCount = count3;
//            modeId = outcome3Id;
//        }
//
//        if (count4 > modeCount) {
//            modeCount = count4;
//            modeId = outcome4Id;
//        }
//
//        return outcomeRepository.findById(modeId).get();
    }

    private  void resetQuiz(Quiz quiz){
        quiz.setCurrentQuestion(quiz.findFirstQuestionID());
        for (Question question : quiz.getAllQuestions()){
            question.setOutcome(null);
            questionRepository.save(question);
        }
    }


}
