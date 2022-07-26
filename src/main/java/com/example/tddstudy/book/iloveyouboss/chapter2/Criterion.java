package com.example.tddstudy.book.iloveyouboss.chapter2;

import com.example.tddstudy.book.iloveyouboss.chapter1.Scoreable;

public class Criterion implements Scoreable {
    private Weight weight;
    private Answer answer;
    private int score;

    public Criterion( Answer answer, Weight weight) {
        this.weight = weight;
        this.answer = answer;
    }

    public Answer getAnswer() {
        return answer;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getScore() {
        return score;
    }
}
