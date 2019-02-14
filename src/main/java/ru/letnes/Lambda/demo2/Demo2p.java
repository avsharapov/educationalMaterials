package ru.letnes.Lambda.demo2;

import java.util.function.Predicate;

public class Demo2p {
    public static void main(String[] args) {

        Predicate<String> stringPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //System.out.println("Demo2p.p1.test");
                return s.isEmpty();
            }
        };

        System.out.println(stringPredicate.test("")); //true
        System.out.println(stringPredicate.test("1")); //false
        System.out.println(stringPredicate.negate().test("")); //false

        Predicate<String> stringPredicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //System.out.println("Demo2p.p2.test");
                return s.length() > 2;
            }
        };

        System.out.println(stringPredicate.and(stringPredicate1).test("")); //false
        System.out.println(stringPredicate.and(stringPredicate1).test("1")); //false
        System.out.println(stringPredicate.and(stringPredicate1).negate().test("")); //true

        Predicate<String> or = stringPredicate.or(stringPredicate1);
        System.out.println(or.test("")); //true
        System.out.println(or.test("1")); //false
        System.out.println(or.negate().test("")); //false
    }
}
