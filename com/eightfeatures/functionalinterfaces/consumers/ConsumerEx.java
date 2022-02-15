package com.eightfeatures.functionalinterfaces.consumers;

import java.util.function.Consumer;

/*
Java Consumer is a functional interface which represents an operation that accepts a single input argument and returns
no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
 */

public class ConsumerEx {
    public static void main(String[] args) {
        Consumer<String> showThreeTimes = value -> {
            System.out.println(value);
            System.out.println(value);
            System.out.println(value);
        };

        showThreeTimes.accept("blue sky");
        showThreeTimes.accept("old falcon");
    }
}
