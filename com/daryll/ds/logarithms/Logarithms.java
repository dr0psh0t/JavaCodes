package com.daryll.ds.logarithms;

public class Logarithms {

    public static void main(String[] args) {
        examples();
    }

    /*  What Are Logarithms?

    A logarithm is a mathematical operation that determines how many times a certain number,
    called the base, is multiplied by itself to reach another number. Because logarithms
    relate geometric progressions to arithmetic progressions, examples are found throughout
    nature and art, such as the spacing of guitar frets, mineral hardness, and the intensities
    of sounds, stars, windstorms, earthquakes and acids. Logarithms even describe how humans
    instinctively think about numbers.

    Logarithms were invented in the 17th century as a calculation tool by Scottish mathematician
    John Napier (1550 to 1617), who coined the term from the Greek words for ratio (logos) and
    number (arithmos). Before the invention of mechanical (and later electronic) calculators,
    logarithms were extremely important for simplifying computations found in astronomy,
    navigation, surveying, and later engineering.
     */

    /*
    An example: folding paper

    Logarithms characterize how many times you need to fold a sheet of paper to get 64 layers.
    Every time you fold the paper in half, the number of layers doubles. Mathematically speaking,
    2 (the base) multiplied by itself a certain number of times is 64. How many multiplications
    are necessary? This question is written as:

    log2(64) = x
     */
    public static void example1() {
        double num1 = Math.log(64);
        double num2 = Math.log(2);
        System.out.println(num1 / num2);    //  6.0
    }
    /*
    A logarithm can be thought of as the inverse of an exponential, so the above equation has
    the same meaning as:

    2^x = 64

    Since 2 x 2 x 2 x 2 x 2 x 2 = 64, 2^6 = 64. This means if we fold a piece of paper in half
    six times, it will have 64 layers. Consequently, the base-2 logarithm of 64 is 6, so log2(64) = 6.
     */

    /*
    To do a logarithm in a base other than 10 or e, we employ a property intrinsic
    to logarithms. From our first example above, log2(64) may be entered into a
    calculator as “log(64)/log(2)” or “ln(64)/ln(2)”; either will give the desired
    answer of 6. Likewise, log1/100(1/1022) equals “log(1/1022)/log(1/100)” and
    “ln(1/1022)/ln(1/100)” for an answer of 11.
     */

    public static void examples() {

        /*  Logarithmic form        Exponential form
            ----------------------------------------
            log2(64) = 6            2^6 = 64
            log10(100,000) = 5      10^5 = 100,000
            log2(8) = 3             2^3 = 8
            log2(1/8) = -3          2^-3 = 1/8
            log5s = r               5^r = s
         */

        System.out.println(Math.log(64) / Math.log(2)); //  6
        System.out.println(Math.pow(2, 6));             //  64

        System.out.println(Math.log10(100000)); //  5.0
        System.out.println(Math.pow(10, 5));    //  100,000

        System.out.println(Math.log(8) / Math.log(2));  //  3
        System.out.println(Math.pow(2, 3));             //  8

        System.out.println((int) Math.log(1/8) / Math.log(2));  //  -3
        System.out.println(Math.pow(2, -3));                    //  1/8
    }
}