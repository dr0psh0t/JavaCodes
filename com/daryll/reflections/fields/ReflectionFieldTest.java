package com.daryll.reflections.fields;

import com.daryll.reflections.MyObject;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionFieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class<?> aClass = MyObject.class;

        //  The Field class is obtained from the Class object. Here is an example:
        Field[] fields = aClass.getFields();
        System.out.println("fields = "+ Arrays.toString(fields));

        //  The Field[] array will have one Field instance for each public field declared in the class.
        //  If you know the name of the field you want to access, you can access it like this:
        Field booleanField = aClass.getField("booleanField");
        Field intField = aClass.getField("intField");
        Field doubleField = aClass.getField("doubleField");
        Field stringField = aClass.getField("stringField");

        System.out.println();
        System.out.println(booleanField.toString());
        System.out.println(intField.toString());
        System.out.println(doubleField.toString());
        System.out.println(stringField.toString());

        //  Field Name and Field Type
        //  get its field name using Field.getName() and determine the field type using Field.getType()
        System.out.println();
        System.out.println(booleanField.getName()+"="+booleanField.getType().toString());
        System.out.println(intField.getName()+"="+intField.getType().toString());
        System.out.println(doubleField.getName()+"="+doubleField.getType().toString());
        System.out.println(stringField.getName()+"="+stringField.getType().toString());

        //  Getting and Setting Field Values. Once you have obtained a Field reference you can get and set its values
        //  using the Field.get() and Field.set() methods, like this:
        MyObject objectInstance = new MyObject();
        stringField.set(objectInstance, "newvaluetest");
        System.out.println(stringField.get(objectInstance));
    }
}

/* OUTPUT:
fields = [public int com.daryll.reflections.MyObject.intField, public boolean com.daryll.reflections.MyObject.booleanField, public double com.daryll.reflections.MyObject.doubleField, public java.lang.String com.daryll.reflections.MyObject.stringField]

public boolean com.daryll.reflections.MyObject.booleanField
public int com.daryll.reflections.MyObject.intField
public double com.daryll.reflections.MyObject.doubleField
public java.lang.String com.daryll.reflections.MyObject.stringField

booleanField=boolean
intField=int
doubleField=double
stringField=class java.lang.String
newvaluetest
 */