package com.example.the_best_quiz_ever.model_DTOs;

public class ChoiceDTO {
    private Long answerId;
    private Long qNumber;

    public ChoiceDTO(Long answerId, Long qNumber) {
        this.answerId = answerId;
        this.qNumber = qNumber;
    }

    public ChoiceDTO() {
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getqNumber() {
        return qNumber;
    }

    public void setqNumber(Long qNumber) {
        this.qNumber = qNumber;
    }
}
