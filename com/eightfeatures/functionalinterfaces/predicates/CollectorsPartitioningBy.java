package com.eightfeatures.functionalinterfaces.predicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
The Collectors.PartitioningBy returns a Collector which partitions the input elements according to a Predicate, and
organizes them into a Map<Boolean, List<T>>.
 */
public class CollectorsPartitioningBy {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,-5,-6,-7,-8);
        Predicate<Integer> isPositive = e -> e > 0;

        Map<Boolean, List<Integer>> groups = values.stream().collect(Collectors.partitioningBy(isPositive));

        System.out.println(groups.get(true));
        System.out.println(groups.get(false));

        List<List<Integer>> subSets = new ArrayList<>(groups.values());
        System.out.println(subSets);
    }
}
//  We have a list of integers. The list is partitioned into two sublists: positive and negative.
/*
[1, 2, 3, 4]
[-5, -6, -7, -8]
[[-5, -6, -7, -8], [1, 2, 3, 4]]
 */