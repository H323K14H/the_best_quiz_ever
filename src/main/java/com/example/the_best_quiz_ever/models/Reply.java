package com.example.the_best_quiz_ever.models;

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
