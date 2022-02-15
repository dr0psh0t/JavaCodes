package com.eightfeatures.stringjoiner;

import java.util.StringJoiner;

public class AddingPrefixSuffix {

    public static void main(String[] args) {

        //  Passing comma(,) as delimeter and opening bracket "(" as prefix and closing bracket ")" as suffix
        StringJoiner mystring = new StringJoiner(",", "(", ")");

        //  joining multiple string by using add() method
        mystring.add("Negan");
        mystring.add("Rick");
        mystring.add("Maggie");
        mystring.add("Daryl");

        //  displaying the output String
        System.out.println(mystring);
    }
}
/*
output:

(Negan,Rick,Maggie,Daryl)
*/