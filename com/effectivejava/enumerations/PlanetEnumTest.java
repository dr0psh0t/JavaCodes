package com.effectivejava.enumerations;

public class PlanetEnumTest {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("100");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();

        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
    }

    private enum Planet {
        MERCURY(3.302e+23, 2.439e6),
        VENUS(3.302e+23, 2.439e6),
        EARTH(4.869e+24, 6.052e6),
        MARS(3.302e+23, 2.439e6),
        JUPITER(3.302e+23, 2.439e6),
        SATURN(3.302e+23, 2.439e6),
        URANUS(3.302e+23, 2.439e6),
        NEPTUNE(3.302e+23,2.439e6);

        private final double mass;
        private final double radius;
        private final double surfaceGravity;

        private static final double G = 6.67300E-11;

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius * radius);
        }

        public double mass() { return mass; }
        public double radius() { return radius; }
        public double surfaceGravity() { return surfaceGravity; }

        public double surfaceWeight(double mass) {
            return mass * surfaceGravity;
        }
    }
}