package com.daryll.generics;

import java.util.ArrayList;
import java.util.List;

public class AnyWildCardDemo2 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("daryll");
        list.add("david");
        print(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        print(list1);
    }

    public static void print(List<?> list) {
        System.out.println(list);
    }
}
