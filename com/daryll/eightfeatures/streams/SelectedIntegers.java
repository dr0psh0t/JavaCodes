package com.daryll.eightfeatures.streams;

import java.util.stream.Stream;

public class SelectedIntegers {
    public static void main(String[] args) {

        //  display 6 numbers that are divisible by 3 starting from 1
        Stream.iterate(1, count -> count + 1)
                .filter(number -> number % 3 == 0)
                .limit(6)
                .forEach(System.out::println);
    }
}
/*
output:

3
6
9
12
15
18
 */