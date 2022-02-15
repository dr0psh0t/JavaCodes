package com.eightfeatures.lambdas;

@FunctionalInterface
interface MyFunctionalInterface {
    //  a method with no parameter
    String sayHello();
}

public class NoParameter {

    public static void main(String[] args) {

        MyFunctionalInterface msg = () -> "Hello";

        System.out.println(msg.sayHello());
    }
}
/*
output:

Hello
 */