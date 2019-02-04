package ru.letnes.Lambda.demo2;

import java.util.function.BinaryOperator;

public class Demo2b {

    public static void main(String[] args) {
        BinaryOperator<String> stringBinaryOperator = new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s.concat(s2);
            }
        };
        System.out.println(stringBinaryOperator.apply("Hello ", "world!")); //Hello world!
    }
}
