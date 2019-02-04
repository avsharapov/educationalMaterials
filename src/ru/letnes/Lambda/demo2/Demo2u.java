package ru.letnes.Lambda.demo2;

import java.util.function.UnaryOperator;

public class Demo2u {

    public static void main(String[] args) {
        UnaryOperator<String> stringUnaryOperator = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        System.out.println(stringUnaryOperator.apply("hello!")); //HELLO!
    }
}
