package com.example.the_best_quiz_ever.model_DTOs;

import com.example.the_best_quiz_ever.models.Outcome;
import com.example.the_best_quiz_ever.models.Question;

public class Reply {



    private Question nextQuestion;

    private Outcome outcome;


    public Reply(Question nextQuestion, Outcome outcome) {

        this.nextQuestion = nextQuestion;
        this.outcome = outcome;
    }

    public Reply(){

    }

    public Question getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(Question nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
} // last
