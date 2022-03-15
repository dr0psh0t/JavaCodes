package com.daryll.eightfeatures.methodreferences;

//  Method reference to an Instance method of a class :

interface B {
    void add(int x, int y);
}

class Addition {
    public void sum(int a, int b) {
        System.out.println("The sum is : "+(a+b));
    }
}

public class TestInstanceMethodReference {
    public static void main(String[] args) {
        Addition addition = new Addition();

        //  Using Lambda Expression
        B b1 = (a,b) -> System.out.println("The sum is : "+(a+b));
        b1.add(10, 14);

        //  Using Method Reference
        B b2 = addition::sum;
        b2.add(100, 140);
    }
}
/*
we have functional Interface B. We have implemented the single abstract method
add(int x, int y) using Lambda expression in highlighted line. While using Method
reference, we have just referred the similar already existing method sum(int a, int b)
of class Addition but after creating an object of the class this time.
 */