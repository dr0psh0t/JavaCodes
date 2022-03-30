package com.daryll.tests;

public class House {

    private int floors;
    private int blocks;
    private int doors;

    public House() {}

    public House floors(int floors) {
        this.floors = floors;
        return this;
    }

    public House blocks(int blocks) {
        this.blocks = blocks;
        return this;
    }

    public House doors(int doors) {
        this.doors = doors;
        return this;
    }

    @Override
    public String toString() {
        return "["+floors+","+blocks+","+doors+"]";
    }
}