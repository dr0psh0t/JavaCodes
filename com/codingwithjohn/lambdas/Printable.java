package com.codingwithjohn.lambdas;

//  Declaring @FunctionalInterface enforces the compiler that you have only one abstract method
//  in your interface
@FunctionalInterface
public interface Printable {

    void print();
}
