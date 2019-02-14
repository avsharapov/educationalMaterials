package ru.letnes.Lambda.demo4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo4 {

    public static void main(String[] args) {
        Supplier<List<String>> listSupplier = () ->
                Arrays.asList("2", "1", "3", "5", "4", "6", "7", "8", "9", "11", "10");

        // filter
        System.out.println("===filter===");
        listSupplier.get().stream().filter(s -> s.startsWith("1")).forEach(System.out::println);

        // sorted
        System.out.println("===sorted===");
        listSupplier.get()
                .stream()
                .sorted()
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);
       // map
        System.out.println("===map===");
        listSupplier.get().stream().map(s -> 2).forEach(System.out::println);
         // match
        System.out.println("===match===");
        System.out.println(listSupplier.get().stream().anyMatch(s -> s.startsWith("1")));
        System.out.println(listSupplier.get().stream().allMatch(s -> s.startsWith("1")));
        System.out.println(listSupplier.get().stream().noneMatch(s -> s.startsWith("1")));
        // count
        System.out.println("===count===");
        System.out.println(listSupplier.get().stream().filter(s -> s.startsWith("1")).count());
        // reduce
        System.out.println("===reduce===");
        listSupplier.get().stream().reduce((result, s2) -> result + "#" + s2).ifPresent(System.out::println);
        System.out.println(listSupplier.get().stream().reduce("Результат: ", (s1, s2) -> s1 + "#" + s2));
       System.out.println(listSupplier.get().parallelStream().reduce("Результат: ", (s, s2) -> s2.startsWith("1") ? s2 : "_", (s1, s2) -> s1 + "#" + s2));



        // collect
        List<String> stringList = listSupplier.get().stream().collect(Collectors.toList());
        Set<String> stringSet = listSupplier.get().stream().collect(Collectors.toSet());

    }
}
