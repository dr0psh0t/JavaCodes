package com.daryll.eightfeatures.functionalinterfaces;

import java.util.function.Function;

public class FunctionInterfaceConcept {
    public static void main(String[] args) {

        /*
        Interface Function<T,R>

        Type Parameters:
            T - the type of the input to the function
            R - the type of the result of the function
         */

        Function<String, Integer> getStringLength = x -> x.length();
        // or Function<String, Integer> getStringLength = String::length;
        int len = getStringLength.apply("This is java 8 and im learning");

        System.out.println(len);

        //  chaining function:
        Function<Integer, Integer> getTimes2ofNumber = x -> x * 2;
        int result = getStringLength.andThen(getTimes2ofNumber).apply("This is Naveen here");
        System.out.println(result);
    }
}
