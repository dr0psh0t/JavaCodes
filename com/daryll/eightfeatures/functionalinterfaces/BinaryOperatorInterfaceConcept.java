package com.daryll.eightfeatures.functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/*
Interface BinaryOperator<T>

    Type Parameters:
        T - the type of the operands and result of the operator

    All Superinterfaces:
        BiFunction<T,T,T>


    Functional Interface:
        This is a functional interface and can therefore be used as the assignment
        target for a lambda expression or method reference.

    @FunctionalInterface
    public interface BinaryOperator<T> extends BiFunction<T,T,T>

    Represents an operation upon two operands of the same type, producing a result of the
    same type as the operands. This is a specialization of BiFunction for the case where the
    operands and the result are all of the same type.

    This is a functional interface whose functional method is BiFunction.apply(Object, Object).
 */
public class BinaryOperatorInterfaceConcept {
    public static void main(String[] args) {

        BinaryOperator<Integer> sumOfTwoNumbers1 = (x1, x2) -> x1 + x2;
        // or BinaryOperator<Integer> sum = Integer::sum;

        int sum = sumOfTwoNumbers1.apply(10, 20);
        System.out.println(sum);

        //  BiFunction interface:
        BiFunction<Integer, Integer, Integer> sumOfTwoNumbers2 = (x1, x2) -> x1 + x2;
        // or BiFunction<Integer, Integer, Integer> sumOfTwoNumbers = Integer::sum;

        int sumResult = sumOfTwoNumbers2.apply(30, 40);
        System.out.println(sumResult);
    }
}
