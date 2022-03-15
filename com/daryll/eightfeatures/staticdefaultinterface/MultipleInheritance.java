package com.daryll.eightfeatures.staticdefaultinterface;

interface MyInterface3 {

    default void newMethod() {
        System.out.println("Newly added default method of MyInterface3");
    }

    void existingMethod(String str);
}

interface MyInterface4 {

    default void newMethod() {
        System.out.println("Newly added default method");
    }

    void disp(String str);
}

public class MultipleInheritance implements MyInterface3, MyInterface4 {

    public void existingMethod(String str) {
        System.out.println("String is: "+str);
    }

    public void disp(String str) {
        System.out.println("String is: "+str);
    }

    //  implementation of duplicate default method
    @Override
    public void newMethod() {
        System.out.println("Implementation of default method");
    }

    public static void main(String[] args) {
        MultipleInheritance obj = new MultipleInheritance();

        //  calling the default method of interface
        obj.newMethod();

        obj.disp("daryll gwapo");
    }
}
/*
output:

Implementation of default method
String is: daryll gwapo
 */