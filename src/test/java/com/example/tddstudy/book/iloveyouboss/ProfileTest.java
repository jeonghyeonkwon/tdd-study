package com.example.tddstudy.book.iloveyouboss;

import com.example.tddstudy.book.iloveyouboss.chapter2.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @BeforeEach
    public void create(){
        profile = new Profile("Bull Hockey, Inc.");
        question = new BooleanQuestion(1,"Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    public void test(){
//        Profile profile = new Profile("Bull Hockey, Inc.");
//        Question question = new BooleanQuestion(1,"Got bonuses?");

        Answer profileAnswer = new Answer(question,Bool.FALSE);
        profile.add(profileAnswer);

//        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question,Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer,Weight.MustMatch);
        criteria.add(criterion);
    }


    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet(){
//        Profile profile = new Profile("Bull Hockey, Inc.");
//        Question question = new BooleanQuestion(1,"Got bonuses?");
        Answer profileAnswer = new Answer(question,Bool.FALSE);
        profile.add(profileAnswer);
//        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question,Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer,Weight.MustMatch);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertFalse(matches);
    }
    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMetInline(){


        profile.add(new Answer(question,Bool.FALSE));


        criteria.add(new Criterion(
                        new Answer(question,Bool.TRUE),
                        Weight.MustMatch
                    ));

        boolean matches = profile.matches(criteria);
        assertFalse(matches);
    }


    @Test
    public void matchAnswersTrueForAnyDontCareCriteria(){
//        Profile profile = new Profile("Bull Hockey, Inc.");
//        Question question = new BooleanQuestion(1,"Got milk?");
        Answer profileAnswer = new Answer(question,Bool.FALSE);
        profile.add(profileAnswer);
//        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question,Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertTrue(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteriaInline(){


        profile.add(new Answer(question,Bool.FALSE));

        criteria.add( new Criterion(
                            new Answer(question,Bool.TRUE),
                            Weight.DontCare
                        )
                    );

        boolean matches = profile.matches(criteria);
        assertTrue(matches);
    }

}
