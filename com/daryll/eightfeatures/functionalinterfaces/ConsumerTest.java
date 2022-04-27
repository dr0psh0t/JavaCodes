package com.daryll.eightfeatures.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
Interface Consumer<T>

    Type Parameters:
        T - the type of the input to the operation

    All Known Subinterfaces:
        Stream.Builder<T>

    Functional Interface:
        This is a functional interface and can therefore be used as the assignment target for a
        lambda expression or method reference.

    @FunctionalInterface
    public interface Consumer<T>

    Represents an operation that accepts a single input argument and returns no result. Unlike
    most other functional interfaces, Consumer is expected to operate via side-effects.

    This is a functional interface whose functional method is accept(Object).
 */
public class ConsumerTest {
    public static void main(String[] args) {

        Consumer<String> print = x -> System.out.println(x);
        print.accept("This is Naveen here!!!");

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //forEach(Consumer<? super Integer> action);
        list.forEach(x -> System.out.println(x));
    }
}
