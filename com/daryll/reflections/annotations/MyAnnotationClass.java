package com.daryll.reflections.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface MyAnnotationClass {
    String name();
    String value();
}

/*
The @ in front of the interface marks it as an annotation. Once you have
defined the annotation you can use it in your code, as shown in the earlier examples.

The two directives in the annotation definition, @Retention(RetentionPolicy.RUNTIME)
and @Target(ElementType.TYPE), specifies how the annotation is to be used.

@Retention(RetentionPolicy.RUNTIME) means that the annotation can be accessed via
reflection at runtime. If you do not set this directive, the annotation will not be
preserved at runtime, and thus not available via reflection.

@Target(ElementType.TYPE) means that the annotation can only be used ontop of types
(classes and interfaces typically). You can also specify METHOD or FIELD, or you can
leave the target out alltogether so the annotation can be used for both classes,
methods and fields.
 */