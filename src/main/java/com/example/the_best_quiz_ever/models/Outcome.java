package com.example.the_best_quiz_ever.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "outcomes")
public class Outcome {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne
//    @JoinColumn (name = "quiz_id")
//    @JsonIgnoreProperties ({"outcomes"})
//    private Quiz quiz;
    @OneToMany (mappedBy = "outcome")
    @JsonIgnoreProperties ({"outcome"})
    private List<Answer> answers;
    @Column
    private String outcome;
//    @OneToMany (mappedBy = "outcome")
//    @JsonIgnoreProperties({"outcome"})
//    private List<Question> questions;

    public Outcome(Quiz quiz, String outcome) {  //remove quiz
//        this.quiz = quiz;
        this.answers = new ArrayList<>();
        this.outcome = outcome;
//        this.questions = new ArrayList<>();
    }

    public Outcome() {

    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Quiz getQuiz() {
//        return quiz;
//    }
//
//    public void setQuiz(Quiz quiz) {
//        this.quiz = quiz;
//    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

//    public List<Question> getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(List<Question> questions) {
//        this.questions = questions;
//    }
}
