package com.daryll.javainterfaces.comparablecomparator.jenkov;

import java.util.Comparator;

public class Spaceship implements Comparable<Spaceship> {
    private String spaceshipClass = null;
    private String registrationNo = null;

    public Spaceship(String spaceshipClass, String registrationNo) {
        this.spaceshipClass = spaceshipClass;
        this.registrationNo = registrationNo;
    }

    public String getSpaceshipClass() {
        return spaceshipClass;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    @Override
    public int compareTo(Spaceship other) {
        int spaceshipClassComparison = this.spaceshipClass.compareTo(other.spaceshipClass);

        if (spaceshipClassComparison != 0) {
            return spaceshipClassComparison;
        }

        return this.registrationNo.compareTo(other.registrationNo);
    }
}
/*
Notice that the Spaceship class already implements the Comparable interface which compares
Spaceship objects on spaceshipClass first, and then registrationNo. This is not necessary,
by the way, if you want to compare objects using a Comparator. Whether or not the objects
implements the Comparable interface is irrelevant when comparing objects using a Comparator.

Now imagine you want to sort Spaceship objects only based on their registration number,
and ignore the spaceshipClass. Here is a Java Comparator implementation that will do that:
 */
class SpaceshipComparator implements Comparator<Spaceship> {
    @Override public int compare(Spaceship o1, Spaceship o2) {
        return o1.getRegistrationNo().compareTo(o2.getRegistrationNo());
    }
}
/*
 First, notice how the SpaceshipComparator class implements the Comparator interface with
 the type Spaceship specified inside the < > characters ( implements Comparator<Spaceship> ).
 This sets the type of objects this Comparator implementation can compare to Spaceship objects.

Setting the generic type of the Comparator implementation to Spaceship means that the
parameter types of the compare() method can be set to Spaceship, and not Object as it
would have been - if no generic type had been specified ( implements Comparator ).

A Java Comparator implementation is pretty much always specialized to be able to compare
objects of a specific type (class), so specifying a generic type in your Comparator
implementation almost always makes sense.

Second, notice how the compare() method returns the registrationNo of the first Spaceship
parameter compared to the registrationNo of the second Spaceship parameter. This is a
totally valid way of implementing a Comparator.
 */