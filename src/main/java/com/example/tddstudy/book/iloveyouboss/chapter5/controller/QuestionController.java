package com.example.tddstudy.book.iloveyouboss.chapter5.controller;



import com.example.tddstudy.book.iloveyouboss.chapter5.domain.BooleanQuestion;
import com.example.tddstudy.book.iloveyouboss.chapter5.domain.PercentileQuestion;
import com.example.tddstudy.book.iloveyouboss.chapter5.domain.Persistable;
import com.example.tddstudy.book.iloveyouboss.chapter5.domain.Question;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.Clock;
import java.util.List;
import java.util.function.Consumer;



public class QuestionController {
    private Clock clock = Clock.systemUTC();
    @Autowired
    private EntityManager em;

    public Question find(Integer id){
        return em.find(Question.class, id);
    }

    public List<Question> getAll(){
        return em.createQuery("SELECT q FROM Question q",Question.class).getResultList();
    }

    public List<Question> findWithMatchingText(String text){
        return em.createQuery(
                "SELECT q FROM Question q WHERE q.text like '%"+text+"%'",Question.class
        ).getResultList();
    }

    public int addPercentileQuestion(String text, String[] answerChoices){
        return persist(new PercentileQuestion(text,answerChoices));
    }
    public int addBooleanQuestion(String text){
        return persist(new BooleanQuestion(text));
    }

    private int persist(Persistable persistable){
        persistable.setCreateTimestamp(clock.instant());
        executeInTransaction((entityManager)->entityManager.persist(persistable));
        return persistable.getId();
    }
    private void executeInTransaction(Consumer<EntityManager> func){
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            func.accept(em);
            transaction.commit();
        }catch (Throwable t){
            t.printStackTrace();
            transaction.rollback();
        }
    }
    public void setClock(Clock clock){
        this.clock = clock;
    }
    public void deleteAll(){
        executeInTransaction((em)->em.createNativeQuery("DELETE FROM Question").executeUpdate());
    }

}
