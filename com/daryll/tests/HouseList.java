package com.daryll.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class HouseList {

    private List<String> list;

    public HouseList() {
        list = List.of("asd", "dsad", "asd", "fgh");
    }

    public void forEach(Consumer<String> action) {
        for (String s: list) {
            action.accept(s);
        }
    }

    public static void main(String[] args) {
        //HouseList houseList = new HouseList();
        //houseList.forEach(System.out::println);

        //display2("a", "b", "c");
    }

    public static void display(String... args) {
        for (String s:
             args) {
            System.out.println(s);
        }
    }

    public static void display2(String[] args) {
        for (String s:
                args) {
            System.out.println(s);
        }
    }
}
