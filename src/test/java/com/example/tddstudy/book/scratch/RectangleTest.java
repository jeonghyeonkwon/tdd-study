package com.example.tddstudy.book.scratch;

import com.example.tddstudy.book.iloveyouboss.chapter7.Point;
import com.example.tddstudy.book.iloveyouboss.chapter7.Rectangle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.example.tddstudy.book.scratch.ConstrainsSideTo.constrainsSidesTo;

import static org.assertj.core.api.Assertions.*;
public class RectangleTest {
    private Rectangle rectangle;

    @AfterEach
    public void ensureInvariant(){
        assertThat(rectangle).isEqualTo(constrainsSidesTo(100));
    }

    @Test
    public void answersArea(){
        rectangle = new Rectangle(new Point(5,5), new Point(15,10));
        assertThat(rectangle.area()).isEqualTo(50);
    }

    @Test
    public void allowsDynamicallyChangeingSize(){
        rectangle = new Rectangle(new Point(5,5));
        rectangle.setOppositeCorner(new Point(130,130));
        assertThat(rectangle.area()).isEqualTo(15625);
    }
}
