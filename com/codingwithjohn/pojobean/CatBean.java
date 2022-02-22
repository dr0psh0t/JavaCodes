package com.codingwithjohn.pojobean;

import java.io.Serializable;

/*
An example of a JavaBean
To be a JavaBean:
1. No-args constructor
2. Properties must be private
3. Public getters and setters
4. Must be serializable
 */
public class CatBean implements Serializable {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
