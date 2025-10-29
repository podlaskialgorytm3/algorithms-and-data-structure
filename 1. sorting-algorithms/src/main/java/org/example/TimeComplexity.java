package org.example;

public class TimeComplexity {
    RandomNumberGenerator rng = new RandomNumberGenerator();

    public double getTimeComplexity(Sorter sorter, int size){
        long startTime = System.nanoTime();
        Double data [] = rng.getRandomNumbers(-1.0,1.0, size);
        sorter.sort(data);

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000.0;
    }

    public void printTimeComplexity(Sorter sorter){
        System.out.println("TimeComplexity");
        for(int i = 10; i <= 20; i++){
            System.out.println("["+Math.pow(2,i)+"]: " + getTimeComplexity(sorter, (int)Math.pow(2,i)) + " ms");
        }
    }
}
