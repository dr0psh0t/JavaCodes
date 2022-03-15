package com.daryll.eightfeatures.lambdas;

@FunctionalInterface
interface MyFunctionalInterface2 {
    //  a method with single parameter
    int incrementByFive(int a);
}

public class SingleParameter {

    public static void main(String[] args) {

        MyFunctionalInterface2 f = (num) -> num + 5;

        System.out.println(f.incrementByFive(22));
    }
}
/*
output:

27
 */