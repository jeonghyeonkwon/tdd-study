package com.example.tddstudy.book.scratch;


import com.example.tddstudy.book.iloveyouboss.chapter7.Bearing;
import com.example.tddstudy.book.iloveyouboss.chapter7.BearingOutOfRangeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BearingTest {

    @Test
    public void throwsOnNegativeNumber(){
        assertThrows(BearingOutOfRangeException.class,()->new Bearing(-1));
    }

    @Test
    public void throwsWhenBearingTooLarge(){
        assertThrows(BearingOutOfRangeException.class,()-> new Bearing(Bearing.MAX+1));
    }

    @Test
    public void answersValidBearing(){
        assertThat(new Bearing(Bearing.MAX).value()).isEqualTo(Bearing.MAX);
    }

    @Test
    public void answersAngleBetweenItAndAnotherBearing(){
        assertThat(new Bearing(15).angleBetween(new Bearing(12))).isEqualTo(3);

    }

    @Test
    public void angleBetweenIsNegativeWhenThisBearingSmaller(){
        assertThat(new Bearing(12).angleBetween(new Bearing(15))).isEqualTo(-3);
    }

}
