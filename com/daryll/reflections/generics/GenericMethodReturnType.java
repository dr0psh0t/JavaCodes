package com.daryll.reflections.generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericMethodReturnType
{
    public static void main(String[] args) throws NoSuchMethodException
    {
        /*
        In this class it is possible to obtain the generic return type of the
        getStringList() method. In other words, it is possible to detect that
        getStringList() returns a List<String> and not just a List. Here is how:
        */
        Method method = MyClass.class.getMethod("getStringList", null);

        Type returnType = method.getGenericReturnType();

        if (returnType instanceof ParameterizedType)
        {
            ParameterizedType type = (ParameterizedType) returnType;

            Type[] typeArguments = type.getActualTypeArguments();

            for (Type typeArgument : typeArguments)
            {
                Class<?> typeArgClass = (Class<?>) typeArgument;
                System.out.println("typeArgClass = "+typeArgClass);
            }
        }

        /*
        This piece of code will print out the text "typeArgClass = java.lang.String".
        The Type[] array typeArguments array will contain one item - a Class instance
        representing the class java.lang.String. Class implements the Type interface.
         */
    }
}

//  output:
//  typeArgClass = class java.lang.String