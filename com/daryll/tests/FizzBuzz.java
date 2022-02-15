package com.daryll.tests;

import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) {
        solution2();
    }

    public static void solution2() {
        StringBuilder sb = new StringBuilder();

        IntStream.range(1, 51).forEach(number -> {
            /*
            if ((number % 3) == 0) {
                sb.append("Fizz");
            }

            if ((number % 5) == 0) {
                sb.append("Buzz");
            }

            if (sb.length() < 1) {
                sb.append(number);
            }
            System.out.println(sb.toString());*/

            //  or
            System.out.println(sb.append((number % 3) == 0 ? "Fizz" : "").append((number % 5) == 0 ? "Buzz" : "").append(sb.length() == 0 ? number : "").toString());

            sb.setLength(0);
        });
    }

    public static void solution() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 50; ++i) {

            if ((i % 3) == 0) {
                sb.append("Fizz");
            }

            if ((i % 5) == 0) {
                sb.append("Buzz");
            }

            if (sb.length() < 1) {
                sb.append(i);
            }

            System.out.println(sb.toString());
            //  or
            //System.out.println(sb.append((i % 3) == 0 ? "Fizz" : "").append((i % 5) == 0 ? "Buzz" : "").append(sb.length() == 0 ? i : "").toString());

            sb.setLength(0);
        }
    }
}
