package com.daryll.eightfeatures.methodreferences;

//  Constructor Reference
//  When single abstract method’s return type is any Object, we will go with the constructor reference.

interface C {
    Employee getEmployee();
}

interface D {
    Employee getEmployee(String name, int age);
}

class Employee {
    String eName;
    int eAge;

    public Employee() {
        eName = "No-name";
        eAge = 0;
    }

    public Employee(String eName, int eAge) {
        this.eName = eName;
        this.eAge = eAge;
    }

    public void getInfo() {
        System.out.println("I am "+eName+" "+eAge+" years old");
    }
}

public class TestConstructorReference {
    public static void main(String[] args) {

        //  Using Lambda Expression
        C c1 = () -> new Employee();
        c1.getEmployee().getInfo();

        D d1 = (name, age) -> new Employee(name, age);
        d1.getEmployee("Tony", 34).getInfo();

        //  Using Method Reference
        C c2 = Employee::new;
        c2.getEmployee().getInfo();
        D d2 = Employee::new;
        d2.getEmployee("Beer", 44).getInfo();
    }
}
/*
output:
I am No-name 0 years old
I am Tony 34 years old
I am No-name 0 years old
I am Beer 44 years old
 */

/*
In the above code snippet, we have two Functional interfaces C & D. Interface C has
abstract method with no arguments whereas D has with arguments. We will have same
constructor reference code in both cases as shown in the highlighted lines of code.
Also, if you run the code in your development environment, you will get the same
output in each case.
 */