package com.daryll.reflections.annotations;

import java.lang.annotation.Annotation;

public class ClassAnnotations {
    public static void main(String[] args) {

        //  Class Annotations. You can access the annotations of a class, method or field at runtime.
        //  Here is an example that accesses the class annotations:
        Class<?> aClass = TheClass.class;
        Annotation[] annotations = aClass.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotationClass) {
                MyAnnotationClass myAnnotationClass = (MyAnnotationClass) annotation;
                System.out.println("name: "+ myAnnotationClass.name());
                System.out.println("value: "+ myAnnotationClass.value());
            }
        }

        //  You can also access a specific class annotation like this:
        MyAnnotationClass annotation = aClass.getAnnotation(MyAnnotationClass.class);

        if (annotation != null) {
            System.out.println("name: " + annotation.name());
            System.out.println("value: "+ annotation.value());
        }
    }
}
/*
name: annotationClassName
value: annotationClassValue
name: annotationClassName
value: annotationClassValue
 */