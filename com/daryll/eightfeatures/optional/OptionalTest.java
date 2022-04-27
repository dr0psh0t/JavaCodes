package com.daryll.eightfeatures.optional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        String str = null;
        Optional<String> optional = Optional.ofNullable(str);
        optional.ifPresentOrElse(
                foo -> {
                    System.out.println(foo);
                },
                () -> {
                    System.out.println("Null");
                }
        );

        /*String str = "klj";

        Optional<String> optional = Optional.ofNullable(str);

        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Null");
        }*/

        /*
        String str = "kqjwhe";

        String optional = Optional.ofNullable(str).orElse("orElse");

        System.out.println(optional);
        */
    }
}
