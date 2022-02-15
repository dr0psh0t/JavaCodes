package com.codingwithjohn.innserclasses;

public class OuterClass {
    int number = 6;

    public void heyThere() {
        System.out.println("Hey there!");

        class LocalInnerClass {
            String localInnerClassVariable = "Here's Johnny";

            public void printLocalInnerClassVariable() {
                System.out.println(localInnerClassVariable);
            }
        }

        LocalInnerClass lic = new LocalInnerClass();
        lic.printLocalInnerClassVariable();
    }

    //public class InnerClass {
    public static class InnerClass {
        int innerNumber = 8;

        public void whatsUp() {
            System.out.println("What's up from the Inner Class");
        }
    }
}
