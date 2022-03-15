package com.daryll.eightfeatures.functionalinterfaces.consumers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CustomForEach {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,2,3,4,5,6,7);

        Consumer<Integer> consumer = System.out::println;
        forEach(data, consumer);

        System.out.println("----------------");

        forEach(data, System.out::println);
    }

    static <T> void forEach(List<T> data, Consumer<T> consumer) {
        for (T t : data) {
            consumer.accept(t);
        }
    }
}
