package com.effectivejava.enumerations;

public class EnumExtensionInterfaceTest {
    public static void main(String[] args) {
        System.out.println(BasicOperation.TIMES.apply(10,5));
    }

    private interface Operation {
        double apply(double x, double y);
    }

    private enum BasicOperation implements Operation {
        PLUS("+") {
            @Override
            public double apply(double x, double y) { return x+y; }
        },
        MINUS("-") {
            @Override
            public double apply(double x, double y) { return x-y; }
        },
        TIMES("*") {
            @Override
            public double apply(double x, double y) { return x*y; }
        },
        DIVIDE("/") {
            @Override
            public double apply(double x, double y) { return x/y; }
        };

        private final String symbol;

        BasicOperation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() { return symbol; }
    }
}
