package com.daryll.reflections;

public class MyObject {

    public int intField;
    public boolean booleanField;
    public double doubleField;
    public String stringField;

    public MyObject() {}

    public MyObject(String s) {
        stringField = s;
    }

    public MyObject(int i) {
        intField = i;
    }

    public MyObject(double d) {
        doubleField = d;
    }

    public MyObject(boolean b) {
        booleanField = b;
    }

    public void walk() {
        System.out.println("walk");
    }

    public void run() {
        System.out.println("run");
    }

    public void dance() {
        System.out.println("dance");
    }

    public void move() {
        System.out.println("move");
    }

    private void privateTest() {
        System.out.println("privateTest");
    }

    public String doSomething() {
        return "doSomething";
    }

}
