package me.fabricionogueira.sqlgen.resource.sqlgen;

@FunctionalInterface
public interface Buildable<T> {
    T build();
}