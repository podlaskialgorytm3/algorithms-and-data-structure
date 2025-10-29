package org.example;

import org.example.HashTable.HashListChainMultiplicativeHashing;
import org.example.HashTable.HashListChaining;
import org.example.HashTable.HashListChainingModularHashing;
import org.example.HashTable.HashListChainingUniversalHashing;

import java.util.Random;

public class Main  {
    private static Random rand = new Random();
    private final static int DEFAULT_SIZE = 29;
    private final static int COUNT_OF_ELEMENTS = 12;

    private static void getRandomValues(HashListChaining hash, int size){
        for(int i = 0; i < size; i++){
            hash.add(rand.nextInt() % size);
        }
    }

    public static void main(String[] args) {
        HashListChaining [] hashes = new HashListChaining[]{
                new HashListChainingModularHashing(DEFAULT_SIZE),
                new HashListChainMultiplicativeHashing(DEFAULT_SIZE),
                new HashListChainingUniversalHashing(DEFAULT_SIZE)
        };

        for(HashListChaining hash : hashes){
            System.out.println(hash);
            getRandomValues(hash, COUNT_OF_ELEMENTS);
            hash.print();
        }

    }
}