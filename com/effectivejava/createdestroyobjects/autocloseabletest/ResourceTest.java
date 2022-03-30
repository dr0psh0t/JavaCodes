package com.effectivejava.createdestroyobjects.autocloseabletest;

public class ResourceTest {

    public static void main(String[] args) {
        try (ResourceSample resourceSample = new ResourceSample()) {
            resourceSample.doWork();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
