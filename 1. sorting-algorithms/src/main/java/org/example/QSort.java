package org.example;

public class QSort {
   public void quickSort(Double [] data, int left, int right){
       if(left < right){
            int pivotIndex =  partition(data,left,right);
            quickSort(data,left,pivotIndex - 1);
            quickSort(data,pivotIndex+1,right);
       }
   }

   public int partition(Double [] data, int left, int right){
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
       double temp = data[i+1];
       data[i+1] = data[right];
       data[right] = temp;
       return i + 1;
   }
}
