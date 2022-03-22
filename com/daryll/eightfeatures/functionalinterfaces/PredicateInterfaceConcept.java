package com.daryll.eightfeatures.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
Interface Predicate<T>

    Type Parameters:
        T - the type of the input to the predicate

    Functional Interface:
        This is a functional interface and can therefore be used as the assignment target for a
        lambda expression or method reference.


    @FunctionalInterface
    public interface Predicate<T>

    Represents a predicate (boolean-valued function) of one argument.

    This is a functional interface whose functional method is test(Object).
 */
public class PredicateInterfaceConcept {
    public static void main(String[] args) {

        Predicate<Integer> getTimesFive = x -> x > 5;

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,10);
        List<Integer> list2 = list.stream().filter(getTimesFive).collect(Collectors.toList());
        System.out.println(list2);

        //  predicate with negate():
        List<String> namesList = Arrays.asList("Naveen", "Navee", "Nave", "Java", "Jav", "Ja", "J");

        Predicate<String> namesExp = x -> x.startsWith("Naveen");

        List<String> newNamesList = namesList.stream().filter(namesExp.negate()).collect(Collectors.toList());
        System.out.println(newNamesList);
    }
}
