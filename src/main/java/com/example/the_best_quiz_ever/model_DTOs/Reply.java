package com.example.the_best_quiz_ever.model_DTOs;

import com.example.the_best_quiz_ever.models.Question;

public class Reply {



    private Question nextQuestion;



    public Reply(Question nextQuestion) {

        this.nextQuestion = nextQuestion;
    }

    public Reply(){

    }

    public Question getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(Question nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

} // last
