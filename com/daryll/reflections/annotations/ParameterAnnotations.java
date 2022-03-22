package com.daryll.reflections.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParameterAnnotations {
    public static void main(String[] args) throws NoSuchMethodException {

        Method method = TheClass.class.getMethod("doSomethingElse", String.class, int.class, boolean.class);
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Class<?>[] parameterTypes = method.getParameterTypes();

        System.out.println(parameterAnnotations.length);

        int i = 0;

        for (Annotation[] annotations : parameterAnnotations) {
            Class<?> parameterType = parameterTypes[i++];

            for (Annotation annotation : annotations) {
                if (annotation instanceof MyAnnotationParameter) {
                    MyAnnotationParameter myAnnotationParameter = (MyAnnotationParameter) annotation;

                    System.out.println();
                    System.out.println("param: "+parameterType.getName());
                    System.out.println("name: "+myAnnotationParameter.name());
                    System.out.println("value: "+myAnnotationParameter.value());
                }
            }
        }
    }
}

/*OUTPUT:

param: java.lang.String
name: aName
value: aValue

param: int
name: aName2
value: aValue2

param: boolean
name: aName3
value: aValue3
 */