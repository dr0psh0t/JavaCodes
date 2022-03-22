package com.daryll.eightfeatures.methodreferences;

import java.util.Arrays;
import java.util.stream.Stream;

public class MethodReferenceEx2 {
    public static void main(String[] args) {

        String[] nameArray = {"E", "D", "C", "B", "A"};

        Stream.of(nameArray).forEach(System.out::print);
    }
}
