package com.example.the_best_quiz_ever.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name="question_id")
    @JsonIgnoreProperties({"answers"})
    private Question question;

    @ManyToOne
    @JoinColumn (name="outcome_id")
    @JsonIgnoreProperties({"answers"})
    private Outcome outcome;
    @Column
    private String answerText;

    public Answer(Question question, Outcome outcome, String answerText) {
        this.question = question;
        this.outcome = outcome;
        this.answerText = answerText;
    }

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

}