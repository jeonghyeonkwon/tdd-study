package com.example.tddstudy.book.util;

import com.example.tddstudy.book.iloveyouboss.chapter7.util.SparseArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SparseArrayTest {
    private SparseArray<Object> array;
    @BeforeEach
    public void create(){
        array = new SparseArray<>();
    }

    @Test
    public void handlesInsertionInDescendingOrder(){
        array.put(7,"seven");
        array.checkInvariants();
        array.put(6,"six");
        array.checkInvariants();
        assertThat(array.get(6)).isEqualTo("six");
        assertThat(array.get(7)).isEqualTo("seven");
    }



}
