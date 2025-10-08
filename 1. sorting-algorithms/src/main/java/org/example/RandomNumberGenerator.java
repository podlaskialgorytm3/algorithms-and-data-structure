package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;


public class RandomNumberGenerator {
    public Random random = new Random();
    public Double [] randomNumbers;

    public RandomNumberGenerator(){
    }

    public Double [] getRandomNumbers(double min, double max, int n){
        if(max < min){
            throw new IllegalArgumentException("Max must be greater than min!");
        }
        if(max == min){
            throw new IllegalArgumentException("Max must be greater than min!");
        }
        if(n < 1){
            throw new IllegalArgumentException("N must be greater than zero!");
        }

        randomNumbers = new Double[n];

        for(int index = 0; index < n; index++){
            double randomNumber = min + (max - min) * random.nextDouble();
            randomNumbers[index] = randomNumber;
        }

        return randomNumbers;
    }

    public void readRandomNumbers(Double [] randomNumbers){
        for(double number : randomNumbers){
            System.out.println(String.format("%.2f",number) + " ");
        }
    }
}
