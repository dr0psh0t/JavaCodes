package com.daryll.datastructures.logarithms;

public class Mains {

    public static void main(String[] args) {

        /*
        double computer_instructions_persecond = Math.pow(10, 7);
        System.out.println((2 * (Math.pow(computer_instructions_persecond, 2))) / Math.pow(10, 10));
        double numerator = (50 * computer_instructions_persecond) * (Math.log(computer_instructions_persecond) / Math.log(2));
        System.out.println(numerator / computer_instructions_persecond);
         */

        /*serch for 10:
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10

            6, 7, 8, 9, 10: 1
            9, 10: 2
            10: 3
         */
        //  O(log2n)
        System.out.println(Math.log(10) / Math.log(2));
    }
}