package com.eightfeatures.optional;

import java.util.Optional;

/*
Java 8 – Optional orElse() and orElseGet() methods

These two methods orElse() and orElseGet() returns the value of Optional Object
if it is no empty, if the object is empty then it returns the default value passed
to this method as an argument.
 */
public class OrElseOrElseGet {
    public static void main(String[] args) {

        //  creating Optional object from a String
        Optional<String> GOT = Optional.of("Game of Thrones");

        //  Optional.empty() creates an empty Optional object
        Optional<String> nothing = Optional.empty();

        //  orElse() method
        System.out.println(GOT.orElse("Default Value"));
        System.out.println(nothing.orElse("Default Value"));

        //  orElseGet() method
        System.out.println(GOT.orElseGet(() -> "Default Value"));
        System.out.println(nothing.orElseGet(() -> "Default Value"));
    }
}
