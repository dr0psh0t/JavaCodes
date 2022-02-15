package com.eightfeatures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConcatenateTwoStreams {
    public static void main(String[] args) {

        List<String> alphabets = Arrays.asList("A", "B", "C");

        List<String> names = Arrays.asList("Sansa", "Jon", "Arya");

        //  creating two streams from the two lists and concatenating them into one
        Stream<String> opstream = Stream.concat(alphabets.stream(), names.stream());

        //  displaying the elements of the concatenated stream
        opstream.forEach(str -> System.out.print(str+" "));
    }
}
/*
output:

A B C Sansa Jon Arya
*/