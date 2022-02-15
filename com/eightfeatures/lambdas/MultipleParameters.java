package com.eightfeatures.lambdas;

interface StringConcat {
    public String sconcat(String a, String b);
}

public class MultipleParameters {

    public static void main(String[] args) {

        StringConcat s = (str1, str2) -> str1 + str2;

        System.out.println("Result: "+s.sconcat("Hello", "World"));
    }
}
/*
output:

Result: HelloWorld
 */