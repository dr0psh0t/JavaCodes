package com.daryll.eightfeatures.methodreferences;

/*
Reference to super class & child class method using super & this keyword

Now we will see the use of super & this keyword in writing Method references accordingly.
 */

interface AA {
    public void sayHello();
}

class SuperClass {
    public void superHello() {
        System.out.println("I am inside SuperTest class");
    }
}

class ChildClass extends SuperClass {
    public void childHello() {
        System.out.println("I am inside SubTest class");
    }

    public void testHello() {
        //  Using Method reference :super class method
        AA aa1 = super::superHello;
        aa1.sayHello();

        //  Using Lambda Expression :super class method
        AA aa2 = () -> System.out.println("I am inside SuperTest class");
        aa2.sayHello();

        //  Using Method reference :current class method
        AA aa3 = this::childHello;
        aa3.sayHello();

        //  Using Lambda Expression :current class method
        AA a4 = () -> System.out.println("I am inside SubTest class");
        a4.sayHello();
    }
}

public class TestReferenceToSuperAndChildClass {
    public static void main(String[] args) {
        ChildClass t = new ChildClass();
        t.testHello();
    }
}
/*
As in the above code snippet, we have a functional interface ‘A‘ with Single Abstract
method sayHello(). We have two classes SuperClass & ChildClass. Existing methods
superHello() & childHello() are referred to write method references using super &
this keyword respectively.
 */