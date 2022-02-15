package com.daryll.javainterfaces.comparablecomparator.geeksforgeeks;

import java.util.Comparator;

//  class to compare Movies by name
public class NameCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getName().compareTo(m2.getName());
    }
}
