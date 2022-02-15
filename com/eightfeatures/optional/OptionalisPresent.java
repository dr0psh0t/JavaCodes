package com.eightfeatures.optional;

import java.util.Optional;

/*
Solution: Using Optional Class

Optional.ofNullable() method of the Optional class, returns a Non-empty Optional
if the given object has a value, otherwise it returns an empty Optional.
We can check whether the returned Optional value is empty or non-empty using the
isPresent() method.
 */
public class OptionalisPresent {

    public static void main(String[] args) {

        String[] str = new String[10];
        Optional<String> isNull = Optional.ofNullable(str[9]);

        if (isNull.isPresent()) {
            //  getting the substring
            String str2 = str[9].substring(2, 5);
            //  displaying substring
            System.out.println("Substring is: "+str2);
        }
        else {
            System.out.println("Cannot get the substring from an empty string");
        }

        str[9] = "AgraIsCool";

        Optional<String> isNull2 = Optional.of(str[9]);

        //  geting the substring
        String str2 = str[9].substring(2, 5);

        //  displayinh substring
        System.out.print("Substring is: "+str2);
    }
}
