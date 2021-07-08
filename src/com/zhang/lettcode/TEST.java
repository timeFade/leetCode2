package com.zhang.lettcode;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TEST{
    public int a = 0;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class a = TEST.class;
        Field l = a.getField("a");
        l.set(l,12);
        System.out.println(l.get(a));
        System.out.println("hhhh");

    }



}