package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        System.out.println("Sorting alghoritms");

        RandomNumberGenerator rng = new RandomNumberGenerator();
        Double [] data = rng.getRandomNumbers(-100.00,100.00,5);
        Double [] dataInsertionSort = Arrays.copyOf(data, data.length);
        Double [] dataQuickSort = Arrays.copyOf(data, data.length);
    }
}