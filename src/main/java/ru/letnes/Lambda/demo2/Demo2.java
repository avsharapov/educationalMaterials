package ru.letnes.Lambda.demo2;

import java.util.concurrent.Callable;

public class Demo2 {

    public static void main(String[] args) {
        // functional interface example
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Demo3.run");
            }
        };
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Demo3.call");
                return null;
            }
        };

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        // anonim
        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }

}
