package com.example.tddstudy.book.iloveyouboss.chapter7;

public class Bearing {
    public static final int MAX = 359;

    private int value;

    public Bearing(int value){
        if(value < 0 || value > MAX) throw new BearingOutOfRangeException();
    }

    public int value(){
        return value;
    }

    public int angleBetween(Bearing bearing){
        return value - bearing.value;
    }
}
