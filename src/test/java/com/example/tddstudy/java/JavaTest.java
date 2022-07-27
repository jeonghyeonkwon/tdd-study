package com.example.tddstudy.java;

import com.example.tddstudy.javatest.Adress;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class JavaTest {

    // 주소
    @Test
    public void listEquals(){
        List<String> list = new ArrayList<>();
        list.add("값1");
        list.add("값2");
        list.add("값3");
        list.add("값4");
        list.add("값5");
        Adress adress = new Adress();
        List<String> changeList = adress.listSizeChange(list);
        assertThat(list).isEqualTo(changeList);
    }



}
