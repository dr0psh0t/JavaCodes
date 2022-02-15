package com.daryll.reflections.constructors;

import com.daryll.reflections.MyObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ReflectionConstructors {

    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        /*
        Using Java Reflection you can inspect the constructors of classes and instantiate
        objects at runtime. This is done via the Java class java.lang.reflect.Constructor.
        This text will get into more detail about the Java Constructor object.
         */

        //  Obtaining Constructor Objects. The Constructor class is obtained from the Class object. Here is an example:
        Class<?> aClass = MyObject.class;
        Constructor<?>[] constructors = aClass.getConstructors();
        System.out.println("constructors = "+ Arrays.toString(constructors));

        /*The Constructor[] array will have one Constructor instance for each public constructor declared in the class.
        If you know the precise parameter types of the constructor you want to access, you can do so rather than obtain
        the array all constructors. This example returns the public constructor of the given class which takes a String
        as parameter:*/
        Constructor<?> constructorStringParam = aClass.getConstructor(String.class);
        Constructor<?> constructorIntParam = aClass.getConstructor(int.class);
        Constructor<?> constructorBooleanParam = aClass.getConstructor(boolean.class);
        Constructor<?> constructorDoubleParam = aClass.getConstructor(double.class);

        System.out.println();
        System.out.println(constructorStringParam.toString());
        System.out.println(constructorIntParam.toString());
        System.out.println(constructorBooleanParam.toString());
        System.out.println(constructorDoubleParam.toString());

        //  Constructor Parameters. You can read what parameters a given constructor takes like this:
        Class<?>[] parameterTypes1 = constructorStringParam.getParameterTypes();
        Class<?>[] parameterTypes2 = constructorDoubleParam.getParameterTypes();
        Class<?>[] parameterTypes3 = constructorIntParam.getParameterTypes();
        Class<?>[] parameterTypes4 = constructorBooleanParam.getParameterTypes();

        System.out.println();
        System.out.println(Arrays.toString(parameterTypes1));
        System.out.println(Arrays.toString(parameterTypes2));
        System.out.println(Arrays.toString(parameterTypes3));
        System.out.println(Arrays.toString(parameterTypes4));

        //  Instantiating Objects using Constructor Object. You can instantiate an object like this:
        Constructor<?> constructor = MyObject.class.getConstructor(String.class);
        MyObject myObject = (MyObject) constructor.newInstance("Daryll David Dagondon");
        System.out.println(myObject.stringField);

        /*
        The Constructor.newInstance() method takes an optional amount of parameters, but you must supply exactly one
        parameter per argument in the constructor you are invoking. In this case it was a constructor taking a String,
        so one String must be supplied.
         */
    }
}

/* OUTPUT:

constructors = [
public com.daryll.reflections.MyObject(boolean),
public com.daryll.reflections.MyObject(double),
public com.daryll.reflections.MyObject(int),
public com.daryll.reflections.MyObject(java.lang.String),
public com.daryll.reflections.MyObject()
]

public com.daryll.reflections.MyObject(java.lang.String)
public com.daryll.reflections.MyObject(int)
public com.daryll.reflections.MyObject(boolean)
public com.daryll.reflections.MyObject(double)

[class java.lang.String]
[double]
[int]
[boolean]
Daryll David Dagondon
 */