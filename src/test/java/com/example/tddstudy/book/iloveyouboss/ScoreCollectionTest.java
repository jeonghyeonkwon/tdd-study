package com.example.tddstudy.book.iloveyouboss;


import com.example.tddstudy.book.iloveyouboss.chapter6.ScoreCollection;
import com.example.tddstudy.book.iloveyouboss.chapter2.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.collection;
import static org.junit.jupiter.api.Assertions.*;



public class ScoreCollectionTest {

    @Test
    public void test(){
//        fail("아직 구현하지 않음");
    }

    @Test
    public void answersArithmeticMeanOfTwoNumbers(){
        // 준비
        ScoreCollection collection = new ScoreCollection();
        collection.add(()->5);
        collection.add(()->7);

        // 실행
        int actualResult = collection.arithmeticMean();

        //단언
        assertEquals(actualResult,6);
    }

    @Test
    public void matches(){
        Profile profile = new Profile("Bull Hockey, Inc");
        Question question = new BooleanQuestion(1,"Got milk?");

        // must-match 항목이 맞지 않으면 false
        profile.add(new Answer(question, Bool.FALSE));
        Criteria criteria = new Criteria();
        criteria.add(
                new Criterion(
                        new Answer(question, Bool.TRUE),
                        Weight.MustMatch
                )
        );

        assertFalse(profile.matches(criteria));

        // don't care 항목에 대해서는 true
        profile.add(new Answer( question,Bool.FALSE));
        criteria = new Criteria();
        criteria.add(
                new Criterion(
                        new Answer(question, Bool.TRUE),
                        Weight.DontCare
                )
        );
        assertThat(profile.matches(criteria));

        /*
        * 첫 번째 테스트가 실패 하면 두번째 테스트는 실행 되지 않는다 그러므로 분리해서 나누어야 된다.
        * */
    }

    @Test
    public void throwsExceptionWhenAddingNull(){
        ScoreCollection collection = new ScoreCollection();

        assertThrows(IllegalStateException.class,()->{
                collection.add(null);
        });
    }

    @Test
    public void dealsWithIntegerOverflow(){
        ScoreCollection collection = new ScoreCollection();
        collection.add(()->Integer.MAX_VALUE);
        collection.add(()->1);
        System.out.println(collection.arithmeticMean());
        assertTrue(collection.arithmeticMean() < 0);
    }
}
