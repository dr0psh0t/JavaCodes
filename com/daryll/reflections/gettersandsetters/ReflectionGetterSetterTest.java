package com.daryll.reflections.gettersandsetters;

import com.daryll.reflections.MyObject;

import java.lang.reflect.Method;

public class ReflectionGetterSetterTest {

    /*
    Using Java Reflection you can inspect the methods of classes and invoke them at runtime.
    This can be used to detect what getters and setters a given class has. You cannot ask
    for getters and setters explicitly, so you will have to scan through all the methods of
    a class and check if each method is a getter or setter.

    First let's establish the rules that characterizes getters and setters:

        Getter
        A getter method have its name start with "get", take 0 parameters, and returns a value.

        Setter
        A setter method have its name start with "set", and takes 1 parameter.

    Setters may or may not return a value. Some setters return void, some the value set, others
    the object the setter were called on for use in method chaining. Therefore you should
    make no assumptions about the return type of a setter.

    Here is a code example that finds getter and setters of a class:
     */

    public static void main(String[] args) {

        Method[] methods = MyObject.class.getMethods();

        for (Method method : methods) {

            if (isGetter(method)) {
                System.out.println("getter: "+method);
            }

            if (isSetter(method)) {
                System.out.println("setter: "+method);
            }
        }
    }

    public static boolean isGetter(Method method) {

        if (!method.getName().startsWith("get")) {
            return false;
        }

        if (method.getParameterTypes().length != 0) {
            return false;
        }

        return !void.class.equals(method.getReturnType());
    }

    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }

        return method.getParameterTypes().length == 1;
    }
}
/*
getter: public int com.daryll.reflections.MyObject.getIntField()
getter: public boolean com.daryll.reflections.MyObject.getBooleanField()
getter: public double com.daryll.reflections.MyObject.getDoubleField()
getter: public java.lang.String com.daryll.reflections.MyObject.getStringField()
setter: public void com.daryll.reflections.MyObject.setStringField(java.lang.String)
setter: public void com.daryll.reflections.MyObject.setDoubleField(double)
setter: public void com.daryll.reflections.MyObject.setIntField(int)
setter: public void com.daryll.reflections.MyObject.setBooleanField(boolean)
getter: public final native java.lang.Class java.lang.Object.getClass()
 */