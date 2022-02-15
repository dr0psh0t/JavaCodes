package com.eightfeatures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilter {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Melisandre", "Sansa", "Jon", "Daenerys", "Joffery");

        //  get names with length > 6 and convert it to Stream
        Stream<String> longNames = names.stream().filter(str -> str.length() > 6);

        longNames.forEach(str -> System.out.print(str+" "));
    }
}
/*
output:

Melisandre Daenerys Joffery
*/