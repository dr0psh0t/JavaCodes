package com.codingwithjohn.innserclasses;

public class MainClass {
    public static void main(String[] args) {

        OuterClass outer = new OuterClass();
        outer.heyThere();

        //  if InnerClass is not static
        //  OuterClass.InnerClass inner = outer.new InnerClass();

        //  if Inner is static
        OuterClass.InnerClass inner = new OuterClass.InnerClass();

        inner.whatsUp();
    }
}
