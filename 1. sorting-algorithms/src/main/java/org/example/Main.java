package org.example;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        System.out.println("Sorting alghoritms");

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        Double [] randomNumbers = randomNumberGenerator.getRandomNumbers(10,100,5);

        System.out.println("Random numbers are:");
        randomNumberGenerator.readRandomNumbers(randomNumbers);

        /*
        System.out.println("Random numbers are sorted by QuickSort Algorithm:");
        QSort qSort = new QSort();
        qSort.quickSort(randomNumbers,0,randomNumbers.length-1);
        randomNumberGenerator.readRandomNumbers(randomNumbers);
        */

        System.out.println("Random numbers are sorted by InsertionSort Algorithm:");
        ISort iSort = new ISort();
        iSort.insertionSort(randomNumbers);
        randomNumberGenerator.readRandomNumbers(randomNumbers);



    }
}