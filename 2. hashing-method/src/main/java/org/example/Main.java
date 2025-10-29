package org.example;

import org.example.HashTable.HashListChainMultiplicativeHashing;
import org.example.HashTable.HashListChaining;
import org.example.HashTable.HashListChainingModularHashing;

import java.util.Random;

public class Main  {
    private static Random rand = new Random();
    private final static int DEFAULT_SIZE = 11;

    private static void getRandomValues(HashListChaining hash, int size){
        for(int i = 0; i < size; i++){
            hash.add(rand.nextInt() % size);
        }
    }

    public static void main(String[] args) {
        HashListChaining [] hashes = new HashListChaining[]{new HashListChainingModularHashing(DEFAULT_SIZE), new HashListChainMultiplicativeHashing(DEFAULT_SIZE)};

        for(HashListChaining hash : hashes){
            System.out.println(hash);
            getRandomValues(hash, DEFAULT_SIZE);
            hash.print();
        }

    }
}