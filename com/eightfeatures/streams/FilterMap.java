package com.eightfeatures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMap {

    public static void main(String[] args) {

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6);

        //  get the squares of each value in num list and convert it to List
        List<Integer> squares = num.stream().map(n -> n * n).collect(Collectors.toList());

        System.out.println(squares);
    }
}
/*
output:

[1, 4, 9, 16, 25, 36]
*/