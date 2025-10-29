package org.example;

import java.util.StringJoiner;

public class QuickSort implements Sorter {
    private int countOfIteration = 0;
    private RandomNumberGenerator rng = new RandomNumberGenerator();

    @Override
    public void sort(Double [] data){
        if(data == null){
            return;
        }
        if(data.length == 0){
            return;
        }
        quickSort(data,0,data.length-1);
    }
    private void quickSort(Double [] data, int left, int right){
        if(left < right){
            int pivotIndex =  partition(data, left, right);

            quickSort(data, left, pivotIndex-1);
            quickSort(data, pivotIndex+1, right);
        }
    }
    private int partition(Double [] data, int left, int right){
            double pivot = data[right];
            int i = left - 1;

            for(int j = left; j < right; j++){
                if(data[j] <= pivot){
                    i++;
                    double temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    //Iteration count
                    countOfIteration++;
                }
            }
            double temp = data[right];
            data[right] = data[i+1];
            data[i+1] = temp;

            return i+1;
    }
    @Override
    public int getCountOfIteration() {
        return countOfIteration;
    }
    @Override
    public String toString(){
        return new String("=== Algorithm QuickSort === \n" + "Iteration count: " + countOfIteration);
    }
}

