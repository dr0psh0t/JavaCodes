package com.codingwithjohn.pojobean;

import java.io.Serializable;

/*
Java Beans

Special types of Pojos are known as JavaBeans.

    All JavaBeans can be considered as Pojos but not vice-versa.
    The Serializable interface should be implemented by them.
    Fields should be set to private, in order to provide the entire control on fields.
    Fields must have getters, setters, or even both.
    A bean must contain a no-arg constructor.
    Fields can be accessed only by the constructors, or getters and setter.
 */
public class StudentBean implements Serializable {
    private int id;
    private String name;

    public StudentBean() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
