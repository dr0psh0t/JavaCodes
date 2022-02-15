package com.eightfeatures.lambdas;

import java.util.ArrayList;
import java.util.List;

public class IterateForeach {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Rick");
        list.add("Negan");
        list.add("Daryl");
        list.add("Glenn");
        list.add("Carl");

        list.forEach(System.out::println);
    }
}
