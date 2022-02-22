package com.effectivejava.createdestroyobjects.autocloseabletest;

public class ResourceSample implements AutoCloseable {

    public void doWork() {
        System.out.println("Doing Work");
    }

    @Override
    public void close() {
        System.out.println("Calling close()");
    }
}
