package com.daryll.eightfeatures.methodreferences;

//  Method reference to a static method of a class

import java.util.function.Predicate;

interface A {
    boolean checkSingleDigit(int x);
}

class Digit {
    public static boolean isSingleDigit(int x) {
        return x > -10 && x < 10;
    }
}

public class TestStaticMethodReference {
    public static void main(String[] args) {

        //  Using Lambda Expression
        A a1 = (x) -> (x > -10 && x < 10);
        System.out.println(a1.checkSingleDigit(9));

        //  Using Method Reference
        A a2 = Digit::isSingleDigit;
        System.out.println(a2.checkSingleDigit(9));
    }
}
/*
We have functional Interface A. We have implemented the
single abstract method checkSingleDigit(int x) using Lambda expression in
highlighted line. But while using Method reference, we have just referred the
similar already existing static method isSingleDigit(int x) of class Digit.
*/