package com.eightfeatures.arraysparallelsort;

import java.util.Arrays;

/*
Java 8 introduced a new method parallelSort() in the Arrays class of java.util package.
This method is introduced to support the parallel sorting of array elements.

Algorithm of parallel sorting:
1.  The given array is divided into the sub arrays and the sub arrays are further divided
    into the their sub arrays, this happens until the sub array reaches a minimum granularity.
2.  The sub arrays are sorted individually by multiple threads. The parallel sort uses
    Fork/Join Framework for sorting sub arrays in parallel.
3.  The sorted sub arrays are merged.
 */

/*
Example 2: Parallel Sort by specifying the start and end index

We can also specify the start and end for the sorting, in this case the sub
array starting from the start index and ending at the end index is sorted,
the rest of the array is ignored and doesn't get sorted.
 */
public class Example2 {
    public static void main(String[] args) {
        int[] numbers = {22, 89, 1, 32, 19, 5};

        /*
        specifying the start and end index. the start index is
        1 here and the index is 5. which means the elements
        starting from index 1 till index 5 would be sorted.
         */
        Arrays.parallelSort(numbers, 1, 5);

        //  conerting the array to stream and displaying using forEach
        Arrays.stream(numbers).forEach(n -> System.out.print(n+" "));
    }
}
/*
output:

22 1 19 32 89 5
 */