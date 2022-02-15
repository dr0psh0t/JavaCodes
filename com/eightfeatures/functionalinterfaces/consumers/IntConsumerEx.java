package com.eightfeatures.functionalinterfaces.consumers;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/*
IntConsumer represents an operation that accepts a single int-valued argument and returns no result. This is the
primitive type specialization of Consumerforint.
 */
public class IntConsumerEx {
    public static void main(String[] args) {
        Consumer<Integer> printMultiplyBy100 = (val) -> System.out.println(val*100);
        printMultiplyBy100.accept(3);
        printMultiplyBy100.accept(4);
        printMultiplyBy100.accept(5);

        IntConsumer printMultiplyBy50 = a -> System.out.println(a*50);
        printMultiplyBy50.accept(1);
        printMultiplyBy50.accept(2);
        printMultiplyBy50.accept(3);
    }
}
