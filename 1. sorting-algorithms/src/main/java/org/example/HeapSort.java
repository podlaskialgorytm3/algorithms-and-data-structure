package org.example;

public class HeapSort implements Sorter{
    int countOfIteration = 0;
    @Override
    public void sort(Double [] data){
        if(data == null) return;
        if(data.length == 0) return;

        heapSort(data);
    }
    private void heapSort(Double [] data){
        int n = data.length;

        for(int i = (n/2) - 1; i >= 0; i--){
            heapify(data, n, i);
        }

        for(int i = n - 1; i > 0; i-- ){
            double temp =  data[0];
            data[0] = data[i];
            data[i] = temp;

            heapify(data, i, 0);
        }


    }
    private void heapify(Double [] data, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && data[left] > data[largest]){
            largest = left;
        }
        if(right < n && data[right] > data[largest]){
            largest = right;
        }
        if(largest != i){
            double temp = data[i];
            data[i] = data[largest];
            data[largest] = temp;
            heapify(data, n, largest);
        }
    }
    @Override
    public int getCountOfIteration() {
        return countOfIteration;
    }
    @Override
    public String toString(){
        return new String("=== Heap Sort ===" +  "\n" + "Iteration count: " +  countOfIteration);
    }

}
