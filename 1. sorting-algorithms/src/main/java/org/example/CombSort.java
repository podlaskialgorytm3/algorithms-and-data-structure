package org.example;

public class CombSort implements Sorter{
    int countOfIterations = 0;
    @Override
    public void sort(Double[] data){
        if(data == null) return;
        if(data.length == 0) return;
        combSort(data);
    }
    private void combSort(Double[] data){
        int n =  data.length;
        int gap = n;
        double shrink = 1.3;
        boolean sorted = true;

        while(sorted || gap > 1){
            gap = (int)(gap/shrink);
            if( gap < 1){
                gap = 1;
            }
            sorted = false;

            for( int i = 0; i < n - gap; i++){
                if(data[i] > data[i + gap]){
                    Double temp = data[i + gap];
                    data[i + gap] = data[i];
                    data[i] = temp;

                    sorted = true;
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
        return new String("=== Comb Sort ===" +  "\n" + "Iteration count: " +  countOfIteration);
    }
}
