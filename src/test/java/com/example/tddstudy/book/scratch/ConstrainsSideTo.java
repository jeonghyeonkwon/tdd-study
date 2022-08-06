package com.example.tddstudy.book.scratch;

import com.example.tddstudy.book.iloveyouboss.chapter7.Rectangle;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.TestFactory;

public class ConstrainsSideTo extends TypeSafeMatcher<Rectangle> {
    private int length;

    public ConstrainsSideTo(int length){
        this.length = length;
    }

    @Override
    protected boolean matchesSafely(Rectangle rect) {
        return Math.abs(rect.origin().x - rect.opposite().x) <= length &&
                Math.abs(rect.origin().y -rect.opposite().y) <= length;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("both sides must be <= " + length);
    }

    @TestFactory
    public static <T> Matcher<Rectangle> constrainsSidesTo(int length){
        return new ConstrainsSideTo(length);
    }
}
