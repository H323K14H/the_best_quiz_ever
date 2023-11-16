package com.example.the_best_quiz_ever.model_DTOs;

public class QuizDTO {
    private Long id;

    public QuizDTO(Long id) {
        this.id = id;
    }

    public QuizDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
