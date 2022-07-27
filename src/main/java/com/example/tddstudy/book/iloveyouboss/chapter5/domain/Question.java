package com.example.tddstudy.book.iloveyouboss.chapter5.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name="Question")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Question implements Persistable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false,nullable = false)
    private Integer id;

    @Column
    private String text;

    @Column
    private Instant instant;

    protected Question(){}

    public Question(String text){
        this.text = text;
    }

    abstract public List<String> getAnswerChoices();
    abstract public boolean match(int expected, int actual);


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Question #"+getId()+": "+getText());
        getAnswerChoices().stream().forEach((choice)->s.append("\t"+choice));
        return s.toString();
    }
    public boolean match(Answer answer){
        return false;
    }
    public String getAnswerChoice(int i){
        return getAnswerChoices().get(i);
    }

    public int indexOf(String matchingAnswerChoice){
        for(int i=0; i< getAnswerChoices().size(); i++){
            if(getAnswerChoice(i).equals(matchingAnswerChoice))
                return i;
        }
        return -1;
    }

    @Override
    public Instant getCreateTimestamp() {
        return instant;
    }

    @Override
    public void setCreateTimestamp(Instant instant) {
        this.instant = instant;
    }
}
