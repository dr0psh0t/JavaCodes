package com.daryll.eightfeatures.functionalinterfaces.consumers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//  The andThen method returns a composed Consumer that performs,
//  in sequence, this operation followed by the next
//  operation. In the example, we add value 2 to each of the elements
//  in the list and then we print all the elements.

public class ConsumerandThen {
    public static void main(String[] args) {

        ArrayList<Integer> vals = new ArrayList<>();
        vals.add(2);
        vals.add(4);
        vals.add(6);
        vals.add(8);

        Consumer<List<Integer>> addTwo = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, 2+list.get(i));
            }
        };

        Consumer<List<Integer>> showList = list -> list.forEach(System.out::println);

        addTwo.andThen(showList).accept(vals);
        //  or
        addTwo.accept(vals);
        vals.forEach(System.out::println);
    }
}
