package com.daryll.eightfeatures.functionalinterfaces.predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*class BiggerThanFive implements Predicate<Integer> {
    @Override
    public boolean test(Integer v) {
        Integer five = 5;
        return v > five;
    }
}*/

public class PredicateEx {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,3,1,5,6,7,8,9,12);
        //BiggerThanFive btf = new BiggerThanFive();

        Predicate<Integer> btf = v -> v > 5;

        nums.stream().filter(btf).forEach(System.out::println);
    }
}
/*
6
7
8
9
12
 */