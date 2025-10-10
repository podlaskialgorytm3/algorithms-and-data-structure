package org.example;

public class InsertionSort implements Sorter {
    @Override
    public void sort(Double [] data){
        if(data == null){
            return;
        }
        if(data.length == 0){
            return;
        }
        insertionSort(data);
    }
    private void insertionSort(Double [] data){
        int size = data.length;
        for(int i = 1; i < size; i++){
            double key = data[i];
            int j = i - 1;
            while(j >= 0 && data[j] > key){
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = key;
        }
    }
}
