package com.example.tddstudy.book.iloveyouboss;


import com.example.tddstudy.book.iloveyouboss.chapter1.ScoreCollection;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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


}
