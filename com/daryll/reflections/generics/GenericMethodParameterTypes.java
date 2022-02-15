package com.daryll.reflections.generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericMethodParameterTypes
{
    public static void main(String[] args) throws NoSuchMethodException
    {
        //  You can access the generic parameter types of the method parameters like this:

        Method method = MyClass.class.getMethod("setStringList", List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes)
        {
            if (genericParameterType instanceof ParameterizedType)
            {
                ParameterizedType aType = (ParameterizedType) genericParameterType;

                Type[] parameterArgTypes = aType.getActualTypeArguments();

                for (Type parameterArgType : parameterArgTypes)
                {
                    Class<?> parameterArgClass = (Class<?>) parameterArgType;
                    System.out.println("parameterArgClass = "+parameterArgClass);
                }
            }
        }

        /*
        This code will print out the text "parameterArgType = java.lang.String".
        The Type[] array parameterArgTypes array will contain one item - a Class
        instance representing the class java.lang.String. Class implements the
        Type interface.
         */
    }
}

//  output:
//  parameterArgClass = class java.lang.String