package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        System.out.println("Sorting alghoritms");

        RandomNumberGenerator rng = new RandomNumberGenerator();
        TimeComplexity timeComplexity = new TimeComplexity();
        Sorter [] sorters = new  Sorter[]{new QuickSort(), new InsertionSort(), new MergeSort(), new HeapSort(), new CombSort(), new SelectionSort()};

        for(Sorter sorter : sorters){
                System.out.println(sorter);
                timeComplexity.printTimeComplexity(sorter);
        }

    }
}