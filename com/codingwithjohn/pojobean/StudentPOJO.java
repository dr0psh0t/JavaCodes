package com.codingwithjohn.pojobean;

/*
A POJO must not :

    -Extend pre-specified classes: Ex- public class Test extends
     javax.servlet.http.HttpServlet is not considered to be a POJO class.
    -Contain pre-specified annotations: Ex- @javax.persistence.Entity
     public class Test{..} is not a pojo class.
    -Implement prespecified interfaces: Ex- public class Test implements
     javax.ejb.EntityBean { … } is not considered to be a POJO class.
 */
public class StudentPOJO {
    //  default field
    String name;
    //  public field
    public String id;
    //  private fees
    private double fees;

    //  argument-constructor to initialize fields
    public StudentPOJO(String name, String id, double fees) {
        this.name = name;
        this.id = id;
        this.fees = fees;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getFees() {
        return fees;
    }
}
