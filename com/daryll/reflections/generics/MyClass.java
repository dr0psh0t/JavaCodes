package com.daryll.reflections.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyClass {

    /*
    Generic Field Types

    It is also possible to access the generic types of public fields.
    Fields are class member variables - either static or instance variables.
    You can read about obtaining Field objects in the text "Java Generics: Fields".
    Here is the example from earlier, with an instance field called stringList.
     */
    public List<String> stringList = Arrays.asList("daryll", "david", "dagondon");

    /*
    Generic Method Return Types

    If you have obtained a java.lang.reflect.Method object it is possible to obtain
    information about its generic return type. You can read how to obtain Method
    objects in the text "Java Generics: Methods". Here is an example class with a
    method having a parameterized return type:
    */
    public List<String> getStringList() {
        return this.stringList;
    }

    /*
    Generic Method Parameter Types

    You can also access the generic types of parameter types at runtime via
    Java Reflection. Here is an example class with a method taking a
    parameterized List as parameter:
     */
    public void setStringList(List<String> list) {
        this.stringList = list;
    }
}
