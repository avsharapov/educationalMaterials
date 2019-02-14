package ru.letnes.Lambda.demo3;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Demo3 {
    static int d = 10;

    public static void main(String[] args) {
        int ff = 9;
        Function<String, Integer> toInteger = Integer::valueOf;
        BinaryOperator<String> stringBinaryOperator = String::concat;
        Formula formula = (a, b, c) -> {return a + b + c + d + ff;};

        System.out.println(formula.calculate(1, 2, 3)); // 16
        System.out.println(stringBinaryOperator.apply("123", "2")); // 1232
        System.out.println(toInteger.apply("123") + 2); // 125


        Runnable runnable = () -> System.out.println("Thread1.start");
        new Thread(runnable).start();

        new Thread(() -> System.out.println("Thread2.start")).start();

        // constructor reference
        MyClassFactory<MyClass> classFactory = MyClass::new;
        MyClass instance = classFactory.getInstance();
        System.out.println(instance.getNumber());
    }
}
