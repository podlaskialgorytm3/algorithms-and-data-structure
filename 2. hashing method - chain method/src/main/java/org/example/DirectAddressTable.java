package org.example;

public final class DirectAddressTable<E> {
    private final Object[] T;

    public DirectAddressTable(int m) {
        if (m <= 0) throw new IllegalArgumentException("m > 0");
        this.T = new Object[m];
    }

    public void insert(int key, E value) {
        checkKey(key);
        T[key] = value;
    }

    public E search(int key) {
        checkKey(key);
        return (E) T[key];
    }

    public void delete(int key) {
        checkKey(key);
        T[key] = null;
    }

    public E max() {
        for (int i = T.length - 1; i >= 0; i--) {
            if (T[i] != null) return (E) T[i];
        }
        return null; // zbiór pusty
    }

    public int maxKey() {
        for (int i = T.length - 1; i >= 0; i--) {
            if (T[i] != null) return i;
        }
        return -1; // zbiór pusty
    }

    private void checkKey(int key) {
        if (key < 0 || key >= T.length)
            throw new IndexOutOfBoundsException("key out of [0," + (T.length - 1) + "]");
    }

    // Demo
    public static void main(String[] args) {
        DirectAddressTable<String> S = new DirectAddressTable<>(10_000);
        S.insert(1234, "Ala");
        S.insert(9000, "Zosia");

        System.out.println(S.maxKey()); // 9000
        System.out.println(S.max());    // Zosia
    }
}