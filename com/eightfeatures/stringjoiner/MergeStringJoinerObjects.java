package eightfeatures.stringjoiner;

import java.util.StringJoiner;

public class MergeStringJoinerObjects {
    public static void main(String[] args) {

        /*
        * passing comma(,) as delimiter and opening bracket "(" as prefix and
        * closing bracket ")" as suffix
        * */
        StringJoiner mystring = new StringJoiner(",", "(", ")");

        mystring.add("Negan");
        mystring.add("Rick");
        mystring.add("Maggie");
        mystring.add("Daryl");

        System.out.println("First String: "+mystring);

        /*
        * passing hypen - as delimiter and string "pre"
        * as prefix and string "suff" as suffix
        * */
        StringJoiner myanotherstring = new StringJoiner("-", "pre", "suff");

        myanotherstring.add("Sansa");
        myanotherstring.add("Imp");
        myanotherstring.add("Jon");
        myanotherstring.add("Ned");

        System.out.println("Second String: "+myanotherstring);

        /*
        * Merging both the strings
        * the important point to note here is that the output string will be having the
        * delimiter prefix and suffix of the first string (the string which is calling
        * the merge method of StringJoiner
        * */
        StringJoiner mergedString = mystring.merge(myanotherstring);
        System.out.println(mergedString);
    }
}
/*
output:

First String: (Negan,Rick,Maggie,Daryl)
Second String: preSansa-Imp-Jon-Nedsuff
(Negan,Rick,Maggie,Daryl,Sansa-Imp-Jon-Ned)
 */