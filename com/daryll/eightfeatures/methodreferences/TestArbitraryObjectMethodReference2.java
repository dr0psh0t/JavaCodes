package com.daryll.eightfeatures.methodreferences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestArbitraryObjectMethodReference2 {
    public static void main(String[] args) {

        List<String> userList = Arrays.asList("Jones", "Alice", "Zidane", "Bob");

        //  Sorting using Anonymous Inner class. Java 7 classic
        List<String> sortedUserList1 = userList.stream()
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareToIgnoreCase(o2);
                    }
                }).collect(Collectors.toList());

        //  Sorting using Lambda expression
        List<String> sortedUserList2 = userList.stream()
                .sorted((a, b) -> a.compareToIgnoreCase(b)).collect(Collectors.toList());

        System.out.println(sortedUserList2);

        //  Sorting using Method reference
        List<String> sortedUserList3 = userList.stream()
                .sorted(String::compareToIgnoreCase).collect(Collectors.toList());

        System.out.println(sortedUserList3);
    }
}
