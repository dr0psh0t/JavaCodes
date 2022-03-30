package com.daryll.tests;

public class Elvis {

    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {}

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Leave the building.");
    }
}
