package org.example.HashTable;

import java.util.Random;

public class HashListChainingUniversalHashing <T extends Comparable<T>> extends  HashListChaining<T>{
    private final int m;
    private final int[] a;
    private final int r;
    private final Random random;

    public HashListChainingUniversalHashing(int size){
        super(size);
        this.m = size;
        this.random = new Random();
        this.r = 4;
        this.a = new int[r];

        for (int i = 0; i < r; i++) {
            a[i] = 1 + random.nextInt(m - 1);
        }
    }


    @Override
    int countHashId(T value) {
        int hashCode = value.hashCode();
        int key = hashCode & Integer.MAX_VALUE;

        int sum = 0;
        for (int i = 0; i < r; i++) {
            int x_i = (key >> (8 * i)) & 0xFF;
            sum = (sum + a[i] * x_i) % m;
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Haszowanie uniwersalne";
    }
}
