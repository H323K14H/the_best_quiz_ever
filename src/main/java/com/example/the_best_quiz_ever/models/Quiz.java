package com.example.the_best_quiz_ever.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "quizzes")
public class Quiz {

    //    properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Long currentQuestion;

    @OneToMany(mappedBy = "quiz")
    @JsonIgnoreProperties({"quiz"})
    private List<Question> questions;

//    @OneToMany(mappedBy = "quiz")
//    @JsonIgnoreProperties({"quiz"})
//    private List<Outcome> outcomes;

    //    constructor
    public Quiz(String name, Long currentQuestion) {
        this.name = name;
//        this.outcomes = new ArrayList<>();
        this.currentQuestion = currentQuestion;
        this.questions = new ArrayList<>();
    }

    public Quiz() {

    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

//    public void addOutcome(Outcome outcome) {
//        this.outcomes.add(outcome);
//    }

    //    getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getAllQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Outcome> getOutcomes() {
//        return outcomes;
//    }
//
//    public void setOutcomes(List<Outcome> outcomes) {
//        this.outcomes = outcomes;
//    }

    public Long getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Long currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public int getSize() {
        return this.questions.size();
    }

    public Long findFirstQuestionID() {
        Question firstQuestion = this.questions.get(0);

        for (Question question : this.questions){
            if (question.getQuestionNumber() == 1){
                firstQuestion = question;
            }
        }
        return firstQuestion.getId();
    }

    public Question findQuestionByNumber(Long questionNumber) {
        for (Question question : this.questions){
            if (question.getQuestionNumber() == questionNumber) {
                return question;
            }
        }
        return null;
    }


} // last