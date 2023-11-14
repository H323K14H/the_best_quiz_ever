package com.example.the_best_quiz_ever.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn (name="quiz_id")
//    @JsonIgnoreProperties({"questions"})
    private Quiz quiz;

    @Column
    private String questionText;

    @ManyToOne
    @JoinColumn (name="outcome_id")
    @JsonIgnoreProperties ({"question"})
    private Outcome outcome;

    @Column
    private int questionNumber;

//    constructors

    public Question(Quiz quiz, String questionText, Outcome outcome, int questionNumber) {
        this.answers = new ArrayList<>();
        this.quiz = quiz;
        this.questionText = questionText;
        this.outcome = outcome;
        this.questionNumber = questionNumber;
    }

    public Question() {
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }

//    getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }
}
