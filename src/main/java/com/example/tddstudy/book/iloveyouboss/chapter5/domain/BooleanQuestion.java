package com.example.tddstudy.book.iloveyouboss.chapter5.domain;

import com.example.tddstudy.book.iloveyouboss.chapter2.Bool;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@Entity
@DiscriminatorValue(value = "boolean")
public class BooleanQuestion extends Question{

    public BooleanQuestion(){}
    public BooleanQuestion(String text){
        super(text);
    }
    @Override
    public List<String> getAnswerChoices() {
        return Arrays.asList(new String[]{"No","Yes"});
    }

    @Override
    public boolean match(int expected, int actual) {
        return expected == actual;
    }
}
