package org.example;

public class MergeSort implements Sorter{
    int countOfIteration = 0;

    @Override
    public void sort(Double [] data){
        if(data == null ) return;
        if(data.length == 0) return;
        mergeSort(data,0,data.length-1);
    }

    private void mergeSort(Double [] data, int left, int right){
        if( left >= right ) return;
        int mid = (int) Math.floor((left + right)/2);
        mergeSort(data, left, mid);
        mergeSort(data, mid + 1, right);
        merge(data, left, mid, right);

    }
    private void merge(Double [] data, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int k = 0;

        double [] temp = new double[right - left + 1];
        while(i <= mid && j <= right){
            if(data[i] <= data[j]){
                temp[k++] = data[i++];
            }
            else{
                temp[k++] = data[j++];
            }
        }
        while(i <= mid){
            temp[k++] = data[i++];
        }
        while(j <= right){
            temp[k++] = data[j++];
        }
        for(int l = 0; l < temp.length; l++){
            data[left+l] = temp[l];
        }
    }

    @Override
    public int getCountOfIteration(){
        return countOfIteration;
    }

    @Override
    public String toString(){
        return new String("=== Algorithm MergeSort === \n" + "Iteration count: " +  countOfIteration);
    }
}
