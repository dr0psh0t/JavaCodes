package com.daryll.javainterfaces.comparablecomparator.geeksforgeeks;

public class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    //  constructor
    public Movie(String nm, double rt, int yr) {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    //  used to sort movies by year
    @Override public int compareTo(Movie m) {
        return this.year - m.year;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
