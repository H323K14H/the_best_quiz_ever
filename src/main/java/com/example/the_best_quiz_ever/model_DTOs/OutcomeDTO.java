package com.example.the_best_quiz_ever.model_DTOs;

import com.example.the_best_quiz_ever.models.Outcome;

public class OutcomeDTO {

    private String finalResult;


    public OutcomeDTO(String finalResult) {
        this.finalResult = finalResult;
    }

    public String getFinalResult() {
        return "You are " + finalResult + "!";
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }
}
