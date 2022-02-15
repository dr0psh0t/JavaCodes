package com.daryll.reflections.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FieldAnnotations {
    public static void main(String[] args) throws NoSuchFieldException {

        Field field = TheClass.class.getField("myField");
        Annotation[] annotations = field.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotationFields) {
                MyAnnotationFields myAnnotationFields = (MyAnnotationFields) annotation;

                System.out.println("name: "+myAnnotationFields.name());
                System.out.println("value: "+myAnnotationFields.value());
            }
        }

        System.out.println();

        //  You can also access a specific field annotation like this:
        MyAnnotationFields annotation = field.getAnnotation(MyAnnotationFields.class);

        if (annotation != null) {
            System.out.println("name: "+annotation.name());
            System.out.println("value: "+annotation.value());
        }
    }
}
/*
name: annotationFieldName
value: annotationFieldValue

name: annotationFieldName
value: annotationFieldValue
 */