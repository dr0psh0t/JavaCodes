package com.daryll.eightfeatures.methodreferences;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Example of Reference to an Instance Method of an Arbitrary Object of a Particular Type

This type of Instance methods refers to a non-static method that are not bound to a
receiver object. In this casExample of Reference to an Instance Method of an Arbitrary Object of a Particular Type
*/
public class TestArbitraryObjectMethodReference {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(15,33,59,24,40,2,19,25,60);

        //  Using Anonymous Inner class
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2);
            }
        });

        //  Using Anonymous Inner class
        numbers.forEach(System.out::println);

        //  Using Lambda Expression
        Collections.sort(numbers, (i1, i2) -> i1.compareTo(i2));
        numbers.forEach(System.out::println);

        //  Using Method References
        Collections.sort(numbers, (Integer::compareTo));
        numbers.forEach(System.out::println);
    }
}