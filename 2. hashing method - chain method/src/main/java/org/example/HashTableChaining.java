package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class HashTableChaining<K, V> {
    private static class Node<K, V> {
        final K key;
        V value;
        Node(K k, V v) { this.key = k; this.value = v; }
        @Override public String toString() { return "(" + key + "," + value + ")"; }
    }

    private final List<Node<K, V>>[] buckets;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public HashTableChaining(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        buckets = (List<Node<K, V>>[]) new List[capacity];
        for (int i = 0; i < capacity; i++) buckets[i] = new ArrayList<>();
    }

    // Prosta funkcja haszująca: modulo rozmiaru tablicy (z dodatnim wynikiem)
    private int hash(Object key) {
        return Math.floorMod(Objects.hashCode(key), buckets.length);
    }

    public int capacity() {
        return buckets.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) {
        Objects.requireNonNull(key, "key");
        int i = hash(key);
        for (Node<K, V> n : buckets[i]) {
            if (Objects.equals(n.key, key)) {
                n.value = value; // aktualizacja istniejącego klucza
                return
                        ;            }
        }
        buckets[i].add(new Node<>(key, value)); // nowy wpis do listy kubełka
        size++;
    }

    public V get(K key) {
        Objects.requireNonNull(key, "key");
        int i = hash(key);
        for (Node<K, V> n : buckets[i]) {
            if (Objects.equals(n.key, key)) return n.value;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean remove(K key) {
        Objects.requireNonNull(key, "key");
        int i = hash(key);
        Iterator<Node<K, V>> it = buckets[i].iterator();
        while (it.hasNext()) {
            Node<K, V> n = it.next();
            if (Objects.equals(n.key, key)) {
                it.remove();
                size--;
                return true;
            }
        }
        return false;
    }

    // Pomocniczo: wypisz kubełki (dla demonstracji łańcuchowania)
    public void printBuckets() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println(i + " -> " + buckets[i]);
        }
    }
}