package com.example.tddstudy.book.iloveyouboss.chapter7.util;

import java.util.Arrays;
import java.util.Objects;

public class SparseArray <T>{

    public static final int INITAL_SIZE = 1000;
    private int[] keys = new int [INITAL_SIZE];
    private Object[] values = new Object[INITAL_SIZE];
    private int size = 0;

    public void put(int key, T value){
        if(value==null) return;
        int index = binarySearch(key,keys,size);
        if(index != -1 && keys[index] ==key)
            values[index] = value;
        else
            insertAfter(key,value,index);
    }

    private int binarySearch(int key, int[] keys, int size) {
        int low = 0;
        int high = size -1;

        while(low <= high){
            int midIndex = (low + high) /2;
            if(key>keys[midIndex])
                low = midIndex-1;
            else if (key <keys[midIndex])
                high = midIndex -1;
            else
                return midIndex;
        }
        return low -1;
    }



    public int size(){
        return size;
    }

    private void insertAfter(int key, T value, int index){
        int[] newKeys = new int[INITAL_SIZE];
        Object[] newValues = new Object[INITAL_SIZE];
        copyFromBefore(index, newKeys, newValues);

        int newIndex = index+1;
        newKeys[newIndex] = key;
        newValues[newIndex] = value;

        if(size - newIndex != 0)
            copyFromAfter(index, newKeys, newValues);
        keys = newKeys;
        values = newValues;
    }

    private void copyFromAfter(int index, int[] newKeys, Object[] newValues) {
        int start = index +1;
        System.arraycopy(keys,start, newKeys,start+1,size-start);
        System.arraycopy(values,start,newValues,start+1,size-start);
    }

    private void copyFromBefore(int index, int[] newKeys, Object[] newValues) {
        System.arraycopy(keys,0,newKeys,0,index+1);
        System.arraycopy(values,0,newValues,0,index+1);
    }

    @SuppressWarnings("unchecked")
    public T get(int key){
        int index = binarySearch(key,keys,size);
        if(index!=-1 && keys[index]==key)
            return (T) values[index];
        return null;
    }

    public void checkInvariants() throws InvariantException{
        long nonNullValues = Arrays.stream(values).filter(Objects::nonNull).count();
        if(nonNullValues!=size)
            throw new InvariantException("size " + size + " does not match value count of " + nonNullValues);
    }


}
