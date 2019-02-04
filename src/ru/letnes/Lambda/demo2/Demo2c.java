package ru.letnes.Lambda.demo2;

import java.util.function.Consumer;

public class Demo2c {

    public static void main(String[] args) {
        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello, " + s + "!");
            }
        };

        stringConsumer.accept("Mike"); //Hello, Mike!

        Consumer<String> stringConsumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("How are you, " + s + "?");
            }
        };

        stringConsumer.andThen(stringConsumer1).accept("John"); //Hello, John! How are you, John?
    }
}
