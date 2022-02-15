package com.eightfeatures.streams;

//  Java Collectors Example – Collecting Data as Set
//  In this example we are converting the list of students to the stream
//  and then we are applying the Java Stream filter to get the selected records
//  from the stream, after that we are converting that stream to set using
//  Collectors.toSet() method.

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Student2 {

    int id;
    String name;
    int age;

    public Student2(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class CollectingDataAsSet {
    public static void main(String[] args) {

        List<Student2> studentlist = new ArrayList<>();

        studentlist.add(new Student2(11,"Jon",22));
        studentlist.add(new Student2(22,"Steve",18));
        studentlist.add(new Student2(33,"Lucy",22));
        studentlist.add(new Student2(44,"Sansa",23));
        studentlist.add(new Student2(55,"Maggie",18));

        //  get students with id more than 22 and convert it to Set
        Set<Student2> students = studentlist.stream().filter(n -> n.id > 22).collect(Collectors.toSet());

        // Iterating Set
        for (Student2 stu : students) {
            System.out.println(stu.id+" "+stu.name+" "+stu.age);
        }
    }
}
/*
output:

44 Sansa 23
33 Lucy 22
55 Maggie 18
 */