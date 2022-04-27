package com.daryll.eightfeatures.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/*
Interface UnaryOperator<T>

    Type Parameters:
        T - the type of the operand and result of the operator

    All Superinterfaces:
        Function<T,T>

    Functional Interface:
        This is a functional interface and can therefore be used as the
        assignment target for a lambda expression or method reference.


    @FunctionalInterface
    public interface UnaryOperator<T>
    extends Function<T,T>

    Represents an operation on a single operand that produces a result of the
    same type as its operand. This is a specialization of Function for the case
    where the operand and result are of the same type.

    This is a functional interface whose functional method is Function.apply(Object).
 */
public class UnaryOperatorTest {
    public static void main(String[] args) {

        UnaryOperator<Integer> getTimesSevenOfNumber = x -> x * 7;

        int result = getTimesSevenOfNumber.apply(10);
        System.out.println(result);

        Function<Integer, Integer> getTimesTenOfNumber = x -> x * 10;
        System.out.println(getTimesTenOfNumber.apply(40));

        List<String> langList = new ArrayList<>(List.of("Java", "Ruby", "Python"));
        System.out.println(langList);

        //replaceAll(UnaryOperator<String> operator)
        langList.replaceAll(element -> element+" Naveen");
        System.out.println(langList);
    }
}
