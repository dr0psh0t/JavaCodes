package com.daryll.reflections.generics;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericFieldTypes
{
    public static void main(String[] args) throws NoSuchFieldException
    {
        Field field = MyClass.class.getField("stringList");

        Type genericFieldType = field.getGenericType();

        if (genericFieldType instanceof ParameterizedType)
        {
            ParameterizedType aType = (ParameterizedType) genericFieldType;

            Type[] fieldArgTypes = aType.getActualTypeArguments();

            for (Type fieldArgType : fieldArgTypes)
            {
                Class<?> fieldArgClass = (Class<?>) fieldArgType;
                System.out.println("fieldArgClass = "+fieldArgClass);
            }
        }

        /*
        This code will print out the text "fieldArgClass = java.lang.String".
        The Type[] array fieldArgTypes array will contain one item - a Class
        instance representing the class java.lang.String. Class implements
        the Type interface.
         */
    }
}

//  output:
//  fieldArgClass = class java.lang.String