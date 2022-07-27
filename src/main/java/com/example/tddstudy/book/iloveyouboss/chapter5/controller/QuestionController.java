package com.example.tddstudy.book.iloveyouboss.chapter5.controller;


import com.example.tddstudy.book.iloveyouboss.chapter5.domain.Question;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.Clock;
import java.util.List;

@RequiredArgsConstructor

public class QuestionController {
    private Clock clock = Clock.systemUTC();
    private final EntityManager em;

    public Question find(Integer id){
        return em.find(Question.class, id);
    }

    public List<Question> getAll(){
        return em.createQuery("SELECT q FROM Question q",Question.class).getResultList();
    }


}
