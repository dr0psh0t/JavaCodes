package com.daryll.reflections.methods;

import com.daryll.reflections.MyObject;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ReflectionMethodTest {
    public static void main(String[] args) throws NoSuchMethodException {

        Class<?> aClass = MyObject.class;

        //  Obtaining Method Objects. The Method class is obtained from the Class object. Here is an example:
        Method[] methods = aClass.getMethods();
        System.out.println("methods = "+Arrays.toString(methods));

        /*The Method[] array will have one Method instance for each public method declared in the class.

        If you know the precise parameter types of the method you want to access, you can do so rather
        than obtain the array all methods. This example returns the public method named "doSomething",
        in the given class which takes a String as parameter:*/
        Method method = aClass.getMethod("doSomething");
        System.out.println(method);
        System.out.println(aClass.getMethod("move"));
    }
}
