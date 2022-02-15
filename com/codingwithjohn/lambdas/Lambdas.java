package com.codingwithjohn.lambdas;

public class Lambdas {

    public static void main(String[] args) {

        Cat myCat = new Cat();
        Printable lambdaPrintable = () -> System.out.println("Meow");

        printThing(myCat);
        printThing(() -> System.out.println("Meow"));
        printThing(lambdaPrintable);
    }

    static void printThing(Printable thing) {
        thing.print();
    }
}
