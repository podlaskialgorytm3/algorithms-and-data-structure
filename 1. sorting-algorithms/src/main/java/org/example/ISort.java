package org.example;

public class ISort {
    public void insertionSort(Double [] tab){
        if(tab == null){
            return;
        }
        if(tab.length == 0){
            return;
        }
        int size = tab.length;
        for(int i = 1; i < size; i++){
            double key = tab[i];
            int j = i-1;
            while(j >= 0 && tab[j] > key){
                tab[j+1] = tab[j];
                j--;
            }
            tab[j+1] = key;
        }
    }
}
