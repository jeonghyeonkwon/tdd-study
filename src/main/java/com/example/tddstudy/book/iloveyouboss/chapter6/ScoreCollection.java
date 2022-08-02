package com.example.tddstudy.book.iloveyouboss.chapter6;

import com.example.tddstudy.book.iloveyouboss.chapter1.Scoreable;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    private List<Scoreable> scores = new ArrayList<>();

    public void add(Scoreable scoreable){
        if(scoreable==null) throw new IllegalStateException();
        scores.add(scoreable);
    }
    public int arithmeticMean(){
        if(scores.size()==0) return 0;

        int total = scores.stream().mapToInt(Scoreable::getScore).sum();

        return (int)(total / scores.size());
    }
}
