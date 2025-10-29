package org.example;

import java.util.*;

class HashElem<E> {
    private E value;
    private int key;

    public HashElem(E value, int key) {
        this.value = value;
        this.key = key;
    }
    public E getValue() { return value; }
    public void setValue(E value) { this.value = value; }
    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }
}

class HashTable<T> {
    private final List<HashElem<T>>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int m) {
        buckets = (List<HashElem<T>>[]) new List[m];
        for (int i = 0; i < m; i++) buckets[i] = new ArrayList<>();
    }

    private int hash(int key) {
        return Math.floorMod(key, buckets.length); // k mod m (działa też dla ujemnych)
    }

    public void insert(int key, T value) {
        int i = hash(key);
        for (HashElem<T> e : buckets[i]) {
            if (e.getKey() == key) {           // aktualizacja istniejącego klucza
                e.setValue(value);
                return;
            }
        }
        buckets[i].add(new HashElem<>(value, key));
        size++;
    }

    public boolean delete(int key) {
        int i = hash(key);
        Iterator<HashElem<T>> it = buckets[i].iterator();
        while (it.hasNext()) {
            if (it.next().getKey() == key) {
                it.remove();
                size--;
                return true;
            }
        }
        return false;
    }

    public T get(int key) {
        int i = hash(key);
        for (HashElem<T> e : buckets[i]) {
            if (e.getKey() == key) return e.getValue();
        }
        return null;
    }

    public int size() { return size; }

    public void print() {
        for (int b = 0; b < buckets.length; b++) {
            for (HashElem<T> e : buckets[b]) {
                System.out.println("bucket=" + b + " key=" + e.getKey() + " value=" + e.getValue());
            }
        }
    }
}

public class SimpleHashTable {
    public static void main(String[] args) {
        HashTable<String> ht = new HashTable<>(4); // m = 4
        ht.insert(1, "a");
        ht.insert(2, "b");
        ht.insert(3, "c");
        ht.insert(5, "d");  // 5 mod 4 -> kolizja z 1 mod 4
        ht.insert(-3, "e"); // obsługa ujemnych: floorMod

        System.out.println("get(5) = " + ht.get(5));
        ht.print();
    }
}