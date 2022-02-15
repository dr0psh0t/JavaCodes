package com.daryll.reflections.classes;

import com.daryll.reflections.MyObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionClassTest {

    public static void main(String[] args) throws ClassNotFoundException {

        /*  1. The Class Object
        Before you can do any inspection on a class you need to obtain its java.lang.Class object. All types in Java
        including the primitive types (int, long, float etc.) including arrays have an associated Class object. If you
        know the name of the class at compile time you can obtain a Class object like this:
         */
        Class<MyObject> myObjectClass = MyObject.class;
        System.out.println(Arrays.toString(myObjectClass.getMethods()));

        /*  If you don't know the name at compile time, but have the class name as a string at runtime,
        you can do like this:

        String className = ... //obtain class name as string at runtime
        Class class = Class.forName(className);

        When using the Class.forName() method you must supply the fully qualified class name. That is the class name
        including all package names. For instance, if MyObject is located in package com.jenkov.myapp then the fully
        qualified class name is com.jenkov.myapp.MyObject

        The Class.forName() method may throw a ClassNotFoundException if the class cannot be found on the classpath at
        runtime. */
        Class<?> classRef = Class.forName("com.daryll.reflections.MyObject");
        System.out.println();
        System.out.println(Arrays.toString(classRef.getMethods()));

        //  2. Class Name. From a Class object you can obtain its name in two versions. The fully qualified class name
        //  (including package name) is obtained using the getName() method like this:
        System.out.println();
        System.out.println("myObjectClass.getName() = "+myObjectClass.getName());
        System.out.println("classRef.getSimpleName() = "+classRef.getSimpleName());

        //  3. Modifiers. You can access the modifiers of a class via the Class object. The class modifiers are the
        //  keywords "public", "private", "static" etc. You obtain the class modifiers like this:
        int modifiers = myObjectClass.getModifiers();
        System.out.println();
        System.out.println(modifiers);

        //  4. Package Info. You can obtain information about the package from a Class object like this:
        Package packge = myObjectClass.getPackage();
        System.out.println("packge.getName() = "+packge.getName());
        /*
        From the Package object you have access to information about the package like its name. You can also access
        information specified for this package in the Manifest file of the JAR file this package is located in on the
        classpath. For instance, you can specify package version numbers in the Manifest file.
         */

        //  5. Superclass. From the Class object you can access the superclass of the class. Here is how:
        Class<?> superClass = myObjectClass.getSuperclass();
        System.out.println("superClass = "+superClass.getName());
        //  The superclass class object is a Class object like any other, so you can continue doing class reflection on that too.

        //  6. Implemented Interfaces. It is possible to get a list of the interfaces implemented by a given class. Here is how:
        Class<?>[] interfaces = myObjectClass.getInterfaces();
        System.out.println("interfaces = "+ Arrays.toString(interfaces));
        /*
        A class can implement many interfaces. Therefore an array of Class is returned.
        Interfaces are also represented by Class objects in Java Reflection.

        NOTE: Only the interfaces specifically declared implemented by a given class is returned. If a superclass of
        the class implements an interface, but the class doesn't specifically state that it also implements that
        interface, that interface will not be returned in the array. Even if the class in practice implements that
        interface, because the superclass does.

        To get a complete list of the interfaces implemented by a given class you will have to consult
        both the class and its superclasses recursively.
         */

        //  7. Constructors. You can access the constructors of a class like this:
        Constructor<?>[] constructors = myObjectClass.getConstructors();
        System.out.println("constructors = "+Arrays.toString(constructors));

        //  8. Methods. You can access the methods of a class like this:
        Method[] methods = classRef.getMethods();
        System.out.println("methods = "+Arrays.toString(methods));

        //  9. Fields. You can access the fields (member variables) of a class like this:
        Field[] fields = classRef.getFields();
        System.out.println("fields = "+Arrays.toString(fields));

        //  10. Annotations. You can access the class annotations of a class like this:
        Annotation[] annotations = classRef.getAnnotations();
        System.out.println("annotations = "+Arrays.toString(annotations));
    }
}

/* OUTPUT:
[public void com.daryll.reflections.MyObject.run(),
public java.lang.String com.daryll.reflections.MyObject.doSomething(),
public void com.daryll.reflections.MyObject.move(),
public void com.daryll.reflections.MyObject.dance(),
public void com.daryll.reflections.MyObject.walk(), public final void java.lang.Object.wait() throws java.lang.InterruptedException, public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public java.lang.String java.lang.Object.toString(), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]

[public void com.daryll.reflections.MyObject.run(),
public java.lang.String com.daryll.reflections.MyObject.doSomething(),
public void com.daryll.reflections.MyObject.move(),
public void com.daryll.reflections.MyObject.dance(),
public void com.daryll.reflections.MyObject.walk(), public final void java.lang.Object.wait() throws java.lang.InterruptedException, public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public java.lang.String java.lang.Object.toString(), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]

myObjectClass.getName() = com.daryll.reflections.MyObject
classRef.getSimpleName() = MyObject

1
packge.getName() = com.daryll.reflections
superClass = java.lang.Object
interfaces = []
constructors = [public com.daryll.reflections.MyObject(boolean), public com.daryll.reflections.MyObject(double), public com.daryll.reflections.MyObject(int), public com.daryll.reflections.MyObject(java.lang.String), public com.daryll.reflections.MyObject()]
methods = [public void com.daryll.reflections.MyObject.run(), public java.lang.String com.daryll.reflections.MyObject.doSomething(), public void com.daryll.reflections.MyObject.move(), public void com.daryll.reflections.MyObject.dance(), public void com.daryll.reflections.MyObject.walk(), public final void java.lang.Object.wait() throws java.lang.InterruptedException, public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public java.lang.String java.lang.Object.toString(), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]
fields = [public int com.daryll.reflections.MyObject.intField, public boolean com.daryll.reflections.MyObject.booleanField, public double com.daryll.reflections.MyObject.doubleField, public java.lang.String com.daryll.reflections.MyObject.stringField]
annotations = []
 */