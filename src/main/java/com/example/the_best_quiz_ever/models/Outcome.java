package com.example.the_best_quiz_ever.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "outcomes")
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "quiz_id")
    @JsonIgnoreProperties ({"outcomes"})
    private Quiz quiz;
    @OneToMany (mappedBy = "outcome")
    private List<Answer> answers;
    @Column
    private String outcome;

    public Outcome( Quiz quiz, List<Answer> answers, String outcome) {
        this.quiz = quiz;
        this.answers = answers;
        this.outcome = outcome;
    }

    public Outcome() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

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
}
