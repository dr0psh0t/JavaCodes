package com.daryll.tests;

import java.util.Objects;

public class RequrieNonNull {
    public static void main(String[] args) {

        String param = "null";
        methodTest(param);
    }

    public static void methodTest(String param) {
        String s = Objects.requireNonNull(param, "variable is null");
        System.out.println(s);
    }
}
