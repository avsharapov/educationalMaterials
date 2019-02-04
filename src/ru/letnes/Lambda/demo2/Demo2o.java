package ru.letnes.Lambda.demo2;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Demo2o {

    public static void main(String[] args) throws Throwable {
        Optional<String> stringOptional = Optional.of("value");
        Optional<String> nullableStringOptional = Optional.ofNullable(null);
        Optional<String> emptyStringOptional = Optional.empty();


        System.out.println(stringOptional.get()); // value
        System.out.println(stringOptional.isPresent()); // true

        // System.out.println(emptyStringOptional.get()); // Exception in thread "main" java.util.NoSuchElementException: No value present
        System.out.println(emptyStringOptional.isPresent()); // false

        stringOptional.ifPresent(new Consumer<String>() { // Demo2o.consumer.accept value
            @Override
            public void accept(String s) {
                System.out.println("Demo2o.consumer.accept " + s);
            }
        });

        System.out.println(nullableStringOptional.orElseGet(new Supplier<String>() { // null
            @Override
            public String get() {
                return "null";
            }
        }));


        System.out.println(nullableStringOptional.orElseThrow(new Supplier<Throwable>() { //Exception in thread "main" java.lang.NullPointerException: NullPointerException
            @Override
            public Throwable get() {
                return new NullPointerException("NullPointerException");
            }
        }));


    }
}
