package com.example.the_best_quiz_ever.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.util.List;

@Entity
@Table(name = "quizzes")
public class Quiz {

//    properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "quiz")
    private List<Question> questions;

    @Column
    private String name;

    @OneToMany(mappedBy = "quiz")
    @JsonIgnoreProperties ({"outcomes"})
    private List<Outcome> outcomes;
//    Question questions;

    @Column
    private int currentQuestion;

//    constructor
    public Quiz(List<Question> questions, String name, List<Outcome> outcomes, int currentQuestion) {
        this.questions = questions;
        this.name = name;
        this.outcomes = outcomes;
        this.currentQuestion = currentQuestion;
    }

    public Quiz(){

    }

//    getters and setters 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
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

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
} // last
