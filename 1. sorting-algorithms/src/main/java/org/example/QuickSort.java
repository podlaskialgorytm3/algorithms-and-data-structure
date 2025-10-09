package org.example;

public class QuickSort implements Sorter {
    @Override
    public void sort(Double [] data){
        if(data == null || data.length == 0){
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
                }
            }
            double temp = data[right];
            data[right] = data[i+1];
            data[i+1] = temp;
            return i+1;
    }
}
