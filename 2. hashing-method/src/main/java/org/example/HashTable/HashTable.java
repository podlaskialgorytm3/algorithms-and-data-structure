package org.example.HashTable;

public interface HashTable<T extends Comparable<T>> {
    void add(T value);
    T delete(T value);
    T get(T value);
}
