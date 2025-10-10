package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        System.out.println("Sorting alghoritms");

        RandomNumberGenerator rng = new RandomNumberGenerator();
        Sorter [] sorters = new  Sorter[]{new QuickSort(), new InsertionSort()};

        // Testing Paramteters
        for(Sorter sorter : sorters){
            Double [] data = rng.getRandomNumbers(-100.00,100.00,100);
            sorter.sort(data);
            System.out.println(sorter);
        }


    }
}