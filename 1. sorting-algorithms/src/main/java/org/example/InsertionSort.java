package org.example;

public class InsertionSort implements Sorter {
    private int countOfIteration = 0;

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
                //Iteration count
                countOfIteration++;
            }
            data[j+1] = key;
        }
    }
    public int getCountOfIteration() {
        return countOfIteration;
    }

    @Override
    public String toString(){
        return new String("=== Algorithm InsertionSort === \n" + countOfIteration);    }
}
