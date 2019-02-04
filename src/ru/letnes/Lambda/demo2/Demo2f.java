package ru.letnes.Lambda.demo2;

import java.util.function.Function;

public class Demo2f {

    public static void main(String[] args) {
        Function<String, Integer> toInteger = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                //System.out.println("Demo2f.toInteger.apply");
                return Integer.valueOf(s);
            }
        };

        Function<String, String> andThen = toInteger.andThen(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                //System.out.println("Demo2f.andThen.apply");
                return String.valueOf(integer);
            }
        });

        Function<String, Integer> compose = toInteger.compose(new Function<String, String>() {
            @Override
            public String apply(String o) {
                //System.out.println("Demo2f.compose.apply");
                return String.valueOf(o);
            }
        });

        System.out.println(andThen.apply("123")); //123
        System.out.println(compose.apply("123")); //123
    }
}
