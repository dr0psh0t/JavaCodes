package com.daryll.reflections.arrays;

import java.lang.reflect.Array;

public class ReflectionArraysTest {
    public static void main(String[] args) {
        /*
        1. Creating Arrays

        Creating arrays via Java Reflection is done using the java.lang.reflect.Array
        class. Here is an example showing how to create an array:
         */
        int[] intArray = (int[]) Array.newInstance(int.class, 3);
        /*
        This code sample creates an array of int. The first parameter int.class
        given to the Array.newInstance() method tells what type each element in
        the array should be of. The second parameter states how many elements
        the array should have space for.
         */

        /*
        2.  Accessing Arrays

        It is also possible to access the elements of an array using Java Reflection.
        This is done via the Array.get(...) and Array.set(...) methods. Here is an
        example:
         */
        Array.set(intArray, 0, 123);
        Array.set(intArray, 1, 456);
        Array.set(intArray, 2, 789);

        System.out.println("intArray[0] = "+Array.get(intArray, 0));
        System.out.println("intArray[1] = "+Array.get(intArray, 1));
        System.out.println("intArray[2] = "+Array.get(intArray, 2));

        /*
        4.  Obtaining the Component Type of an Array

        Once you have obtained the Class object for an array you can access its
        component type via the Class.getComponentType() method. The component type is
        the type of the items in the array. For instance, the component type of an
        int[] array is the int.class Class object. The component type of a String[]
        array is the java.lang.String Class object.

        Here is an example of accessing the component type array:
         */
        String[] strings = new String[3];
        Class<?> stringArrayClass = strings.getClass();
        Class<?> stringArrayComponentType = stringArrayClass.getComponentType();
        System.out.println(stringArrayComponentType);
    }
}

/*
OUTPUT:

intArray[0] = 123
intArray[1] = 456
intArray[2] = 789
class java.lang.String
 */