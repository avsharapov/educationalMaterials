package ru.letnes.Lambda.demo3;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Demo3 {
    static int d = 10;

    public static void main(String[] args) {
        Function<String, Integer> toInteger = (s) -> {
            return Integer.valueOf(s);
        };
        BinaryOperator<String> stringBinaryOperator = (s, s2) -> {
            return s.concat(s2);
        };
        Formula formula = (a, b, c) -> {
            return a + b + c + d;
        };

        System.out.println(formula.calculate(1, 2, 3)); // 16
        System.out.println(stringBinaryOperator.apply("123", "2")); // 1232
        System.out.println(toInteger.apply("123") + 2); // 125


        Runnable runnable = () -> System.out.println("Thread1.start");
        new Thread(runnable).start();

        new Thread(() -> System.out.println("Thread2.start")).start();

        // constructor reference
        MyClassFactory<MyClass> classFactory = MyClass::new;
        MyClass instance = classFactory.getInstance(5);
        System.out.println(instance.getNumber());
    }
}
