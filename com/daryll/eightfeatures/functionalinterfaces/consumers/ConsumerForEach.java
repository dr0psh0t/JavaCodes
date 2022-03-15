package com.daryll.eightfeatures.functionalinterfaces.consumers;

import java.util.Arrays;
import java.util.List;

public class ConsumerForEach {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("falcon", "wood", "rock", "forest", "river", "water");

        words.forEach(word -> System.out.println(word));
        words.forEach(System.out::println);
    }
}
