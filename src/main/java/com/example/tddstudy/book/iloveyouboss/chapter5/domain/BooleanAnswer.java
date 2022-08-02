package com.example.tddstudy.book.iloveyouboss.chapter5.domain;

public class BooleanAnswer {
    private int questionId;
    private boolean value;

    public BooleanAnswer(int questionId, boolean value) {
        this.questionId = questionId;
        this.value = value;
    }

    boolean getValue(){
        return value;
    }

    public int getQuestionId() {
        return questionId;
    }
}
