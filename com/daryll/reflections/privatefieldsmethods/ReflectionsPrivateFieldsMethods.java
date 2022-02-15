package com.daryll.reflections.privatefieldsmethods;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionsPrivateFieldsMethods {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        /*
        1.  Accessing Private Fields

        To access a private field you will need to call the Class.getDeclaredField(String name)
        or Class.getDeclaredFields() method. The methods Class.getField(String name) and
        Class.getFields() methods only return public fields, so they won't work. Here is a
        simple example of a class with a private field, and below that the code to access that
        field via Java Reflection:
         */
        PrivateObject privateObject = new PrivateObject("The Private Value");
        Field privateStringField = PrivateObject.class.getDeclaredField("privateString");
        privateStringField.setAccessible(true);

        String fieldValue = (String) privateStringField.get(privateObject);
        System.out.println("fieldValue = "+fieldValue);
        /*
        This code example will print out the text "fieldValue = The Private Value", which
        is the value of the private field privateString of the PrivateObject instance
        created at the beginning of the code sample.

        Notice the use of the method PrivateObject.class.getDeclaredField("privateString").
        It is this method call that returns the private field. This method only returns
        fields declared in that particular class, not fields declared in any superclasses.

        Notice the line in bold too. By calling Field.setAcessible(true) you turn off
        the access checks for this particular Field instance, for reflection only. Now
        you can access it even if it is private, protected or package scope, even if the
        caller is not part of those scopes. You still can't access the field using
        normal code. The compiler won't allow it.
         */

        /*
        2.  Accessing Private Methods

        To access a private method you will need to call the
        Class.getDeclaredMethod(String name, Class[] parameterTypes) or
        Class.getDeclaredMethods() method.
        The methods Class.getMethod(String name, Class[] parameterTypes) and
        Class.getMethods() methods only return public methods, so they won't work.
        Here is a simple example of a class with a private method, and below that
        the code to access that method via Java Reflection:
         */
        Method privateStringMethod = PrivateObject.class.getDeclaredMethod("getPrivateString", null);
        privateStringMethod.setAccessible(true);

        String returnValue = (String) privateStringMethod.invoke(privateObject, null);
        System.out.println("returnValue = "+returnValue);

        /*
        This code example will print out the text "returnValue = The Private Value",
        which is the value returned by the method getPrivateString() when invoked on
        the PrivateObject instance created at the beginning of the code sample.

        Notice the use of the method PrivateObject.class.getDeclaredMethod("privateString").
        It is this method call that returns the private method. This method only returns
        methods declared in that particular class, not methods declared in any superclasses.

        Notice the line in bold too. By calling Method.setAcessible(true) you turn off
        the access checks for this particular Method instance, for reflection only.
        Now you can access it even if it is private, protected or package scope, even
        if the caller is not part of those scopes. You still can't access the method
        using normal code. The compiler won't allow it.
         */
    }
}

/*
output:

fieldValue = The Private Value
returnValue = The Private Value
 */