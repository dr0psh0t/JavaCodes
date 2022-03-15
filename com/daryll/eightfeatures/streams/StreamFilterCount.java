package com.daryll.eightfeatures.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamFilterCount {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("");
        names.add("Ajeet");
        names.add("Negan");
        names.add("");
        names.add("Aditya");
        names.add("Steve");
        names.add("");

        //  get count of names with length < 6 and not empty
        long count = names.stream().filter(str -> (str.length() < 6)).filter(str -> (!str.isEmpty())).count();
        System.out.println("There are "+count+" strings with length less than 6 and not empty");
    }
}
/*
output:

There are 3 strings with length less than 6 and not empty
*/