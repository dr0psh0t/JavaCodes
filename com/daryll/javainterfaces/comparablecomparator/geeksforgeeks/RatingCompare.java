package com.daryll.javainterfaces.comparablecomparator.geeksforgeeks;

import java.util.Comparator;

//  class to compare Movies by ratings
public class RatingCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        if (m1.getRating() < m2.getRating()) {
            return -1;
        }

        if (m1.getRating() > m2.getRating()) {
            return 1;
        }

        return 0;
    }
}
