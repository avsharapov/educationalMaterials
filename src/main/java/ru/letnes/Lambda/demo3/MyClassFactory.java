package ru.letnes.Lambda.demo3;

@FunctionalInterface
public interface MyClassFactory<V extends MyClass> {
    V getInstance();
}
