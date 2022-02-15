package com.daryll.reflections.annotations;

@MyAnnotationClass(name = "annotationClassName", value = "annotationClassValue")
public class TheClass {

    @MyAnnotationFields(name = "annotationFieldName", value = "annotationFieldValue")
    public String myField = null;

    @MyAnnotationMethod(name = "annotationMethodName", value = "annotationMethodValue")
    public void doSomething() {
        System.out.println("calling doSomething()");
    }

    public static void doSomethingElse(
            @MyAnnotationParameter(name = "aName", value = "aValue") String parameter,
            @MyAnnotationParameter(name = "aName2", value = "aValue2") int age,
            @MyAnnotationParameter(name = "aName3", value = "aValue3") boolean ok
    ) {
        System.out.println("calling doSomethingElse()");
    }
}
