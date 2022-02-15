package com.eightfeatures.stringjoiner;

//  Joining strings by specifying delimiter

import java.util.StringJoiner;

public class StringJoinerDelimiter {

    public static void main(String[] args) {

        //  passing hyphne -  as delimiter
        StringJoiner mystring = new StringJoiner("-");

        //  joining multiple string by using add() method
        mystring.add("Logan");
        mystring.add("Magneto");
        mystring.add("Rogue");
        mystring.add("Storm");

        //  displaying the output string
        System.out.println(mystring);
    }
}
/*
output:

Logan-Magneto-Rogue-Storm
 */