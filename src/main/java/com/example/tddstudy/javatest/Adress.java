package com.example.tddstudy.javatest;

import java.util.List;

public class Adress {

    public List<String> listSizeChange(List<String> list){
        list.remove(list.size() - 1);
        return list;
    }
}
