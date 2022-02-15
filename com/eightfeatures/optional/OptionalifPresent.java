package com.eightfeatures.optional;

/*
Example: Optional isPresent() vs ifPresent() methods

In the above example, we have seen that by using isPresent() method we can
check whether the particular Optional object(or instance) is empty or no-empty.
There is another method present in the Optional class, which only executes if
the given Optional object is non-empty, the method is ifPresent(). Lets see
an example to understand the difference.
 */

import java.util.Optional;

public class OptionalifPresent {
    public static void main(String[] args) {

        //  creating Optional object from a String
        Optional<String> GOT = Optional.of("Game of Thrones");

        //  Optional.empty() creates an empty Optional object
        Optional<String> nothing = Optional.empty();

        //  isPresent() method: checks whether the given Optional
        //  Object is empty or not.
        System.out.println("Watching Game of Thrones");

        //  ifPresent() method: it executes only if the given Optional
        //  object is non-empty.

        //  this will print as the GOT is non-empty
        GOT.ifPresent(s -> System.out.println("Watching GOT is fun!"));

        //  this will not print as the nothing is empty
        nothing.ifPresent(s -> System.out.println("I prefer getting bored"));
    }
}
