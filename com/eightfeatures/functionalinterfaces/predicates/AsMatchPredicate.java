package com.eightfeatures.functionalinterfaces.predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class AsMatchPredicate {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("book","bookshelf","bookworm","bookcase","bookish","bookkeeper","booklet","bookmark");
        Predicate<String> pred = Pattern.compile("book(worm|mark|keeper)?").asPredicate();
        words.stream().filter(pred).forEach(System.out::println);
    }
}
