package com.daryll.eightfeatures.functionalinterfaces.predicates;

import java.util.function.Predicate;

public class PredicateIsSingleDigit {
    public static void main(String[] args) {

        Predicate<Integer> isThisSingleDigit = x -> (x>-10&&x<10);
        Predicate<Integer> isThisSingleDigit2 = PredicateIsSingleDigit::test;

        System.out.println(isThisSingleDigit.test(9));
        System.out.println(isThisSingleDigit2.test(90));
    }

    public static boolean test(int x) {
        return x>-10&&x<10;
    }
}
