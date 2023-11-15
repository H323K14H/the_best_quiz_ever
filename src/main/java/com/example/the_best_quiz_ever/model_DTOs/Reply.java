package com.example.the_best_quiz_ever.model_DTOs;

import com.example.the_best_quiz_ever.models.Outcome;
import com.example.the_best_quiz_ever.models.Question;

public class Reply {


    private Question nextQuestion;

//    private Outcome outcome;

    private OutcomeDTO outcomeDTO;


    public Reply(Question nextQuestion, OutcomeDTO outcomeDTO) {

        this.nextQuestion = nextQuestion;
        this.outcomeDTO = outcomeDTO;
    }

    public Reply() {

    }

    public Question getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(Question nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    public OutcomeDTO getOutcomeDTO() {
        return outcomeDTO;
    }

    public void setOutcomeDTO(OutcomeDTO outcomeDTO) {
        this.outcomeDTO = outcomeDTO;
    }
} // last
