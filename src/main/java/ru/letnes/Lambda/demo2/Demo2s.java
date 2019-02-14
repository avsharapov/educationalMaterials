package ru.letnes.Lambda.demo2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Demo2s {

    public static void main(String[] args) {
        Supplier<List<String>> listSupplier = new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                return Arrays.asList("1", "2", "3");
            }
        };
        System.out.println(listSupplier.get()); //[1, 2, 3]
    }
}
