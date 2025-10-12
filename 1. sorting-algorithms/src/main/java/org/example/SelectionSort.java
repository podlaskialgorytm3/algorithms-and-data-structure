package org.example;

public class SelectionSort implements Sorter {
    public int countOfIteration = 0;
    @Override
    public void sort(Double [] data){
        if(data == null) return;
        if(data.length == 0) return;
        selectionSort(data);
    }
    private void selectionSort(Double [] data){
        for(int i = 0; i < data.length; i++){
            for(int j = i + 1; j < data.length; j++){
                if(data[i] > data[j]){
                    Double temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
    @Override
    public int getCountOfIteration(){
        return countOfIteration;
    }
    @Override
    public String toString(){
        return new String("=== Selection Sort ===" +  "\n" + "Iteration count: " +  countOfIteration);
    }
}
