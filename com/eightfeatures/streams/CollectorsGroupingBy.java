package com.eightfeatures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//  In this example, we are grouping the elements of a list using groupingBy()
//  method of Collectors class and printing the occurrences of each element in the list.

public class CollectorsGroupingBy {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");

        Map<String, Long> map = names.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );

        System.out.println(map);
    }
}
/*
output:

{Steve=1, Jon=2, Ajeet=3}
*/