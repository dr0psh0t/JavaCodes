package com.daryll.eightfeatures.lambdas;

@FunctionalInterface
interface Addition {
    int sum(int a, int b);
}

@FunctionalInterface
interface Multiplication {
    int product(int a, int b);
}

@FunctionalInterface
interface Subtraction {
    int difference(int a, int b);
}

public class Test {

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {

        Subtraction subtractResult = Test::subtract;

        //  prints 5
        System.out.println(
                subtractResult.difference(10, 5));
    }
}

        /*
        //  1-line lambda expression
        Addition addResult = (a, b) -> a + b;

        //Addition addResult2 = Test::;

        //  multi-line lambda expression
        Multiplication multiplyResult = (a, b) -> {
            return a * b;
        };

        //  using the classic Anonymous class in JDK 7
        Subtraction subtractResult = new Subtraction() {
            @Override
            public int difference(int a, int b) {
                return a - b;
            }
        };

        System.out.println(addResult.sum(5, 5));
        System.out.println(multiplyResult.product(5, 5));
        System.out.println(subtractResult.difference(5, 5));
    }
}*/