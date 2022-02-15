package com.eightfeatures.streams;

//  Getting the average age of students using averagingInt() method

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student3 {
    int id;
    String name;
    int age;

    public Student3(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class CollectorsAveragingInt {

    public static void main(String[] args) {
        List<Student3> studentlist = new ArrayList<>();

        studentlist.add(new Student3(11,"Jon",22));
        studentlist.add(new Student3(22,"Steve",18));
        studentlist.add(new Student3(33,"Lucy",22));
        studentlist.add(new Student3(44,"Sansa",23));
        studentlist.add(new Student3(55,"Maggie",18));

        //  Getting the average Age
        Double avgAge = studentlist.stream()
                .collect(Collectors.averagingInt(s -> s.age));

        System.out.println("Average Age of Students is: "+avgAge);
    }
}
/*
output:

Average Age of Students is: 20.6
*/