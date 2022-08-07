package com.example.tddstudy.book.iloveyouboss.chapter2;

import java.util.HashMap;
import java.util.Map;

public class Profile {
    private Map<String,Answer> answers = new HashMap<>();
    private int score;
    private String name;

    public Profile(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void add(Answer answer){
        answers.put(answer.getQuestionText(), answer);
    }

    public boolean matches(Criteria criteria){
        score = 0;

        boolean kill = false;


        for(Criterion criterion : criteria){

            boolean match = criterion.matches(answerMatching(criterion));

            if(!match && criterion.getWeight() == Weight.MustMatch){
                kill = true;
            }

            if(match){
                score += criterion.getWeight().getValue();
            }

        }
        if(kill) return false;
        return anyMatches(criteria);
    }

    private boolean anyMatches(Criteria criteria) {
        boolean anyMatches = false;
        for(Criterion criterion : criteria)
            anyMatches |= criterion.matches(answerMatching(criterion));
        return anyMatches;
    }

    private Answer answerMatching(Criterion criterion) {
        return answers.get(criterion.getAnswer().getQuestionText());
    }


    public int score(){
        return score;
    }



}
