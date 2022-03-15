package com.daryll.eightfeatures.functionalinterfaces.predicates;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ListRemoveIf {
    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        words.add("sky");
        words.add("warm");
        words.add("winter");
        words.add("cloud");
        words.add("pen");
        words.add("den");
        words.add("tree");
        words.add("sun");
        words.add("silk");

        Predicate<String> hasThreeChars = word -> word.length() == 3;
        words.removeIf(hasThreeChars);
        System.out.println(words);
        System.out.println(words.size());
    }
}
/*
[warm, winter, cloud, tree, silk]
5
 */