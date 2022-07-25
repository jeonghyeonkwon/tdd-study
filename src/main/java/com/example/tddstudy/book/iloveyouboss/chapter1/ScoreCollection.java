package com.example.tddstudy.book.iloveyouboss.chapter1;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {

    private List<Scoreable> scores = new ArrayList<>();

    public void add(Scoreable scoreable){
        scores.add(scoreable);
    }
    public int arithmeticMean(){
        int total = scores.stream().mapToInt(scoreable -> scoreable.getScore()).sum();
        return total / scores.size();
    }
}
