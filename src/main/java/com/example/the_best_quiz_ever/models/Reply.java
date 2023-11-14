package com.example.the_best_quiz_ever.models;

public class Reply {

    private String selectQuestion;

    private String options;

    private boolean optionSelected;

    public Reply(String selectQuestion, String options, boolean optionSelected) {
        this.selectQuestion = selectQuestion;
        this.options = options;
        this.optionSelected = optionSelected;
    }

    public Reply(){

    }

    public String getSelectQuestion() {
        return selectQuestion;
    }

    public void setSelectQuestion(String selectQuestion) {
        this.selectQuestion = selectQuestion;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public boolean isOptionSelected() {
        return optionSelected;
    }

    public void setOptionSelected(boolean optionSelected) {
        this.optionSelected = optionSelected;
    }
} // last
