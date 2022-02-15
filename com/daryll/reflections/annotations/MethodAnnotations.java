package com.daryll.reflections.annotations;
// daryll gwapo

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodAnnotations {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //  You can access method annotations like this:
        Method method = TheClass.class.getMethod("doSomething");
        Annotation[] annotations = method.getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotationMethod) {
                MyAnnotationMethod myAnnotationMethod = (MyAnnotationMethod) annotation;

                System.out.println("name: "+myAnnotationMethod.name());
                System.out.println("value: "+myAnnotationMethod.value());
            }
        }

        System.out.println();

        //  You can also access a specific method annotation like this:
        MyAnnotationMethod annotation = method.getAnnotation(MyAnnotationMethod.class);

        if (annotation != null) {
            System.out.println("name: "+annotation.name());
            System.out.println("value: "+annotation.value());
        }
    }
}

/*
name: annotationMethodName
value: annotationMethodValue

name: annotationMethodName
value: annotationMethodValue
 */