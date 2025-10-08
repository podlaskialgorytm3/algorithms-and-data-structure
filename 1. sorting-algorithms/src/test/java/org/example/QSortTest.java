package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;



class QSortTest {
    QSort qSort = new QSort();
    RandomNumberGenerator rng = new RandomNumberGenerator();

    @Test
    public void shouldBeEmptyArray_whenEmptyArrayIsEnter(){
        Double tab [] = {};
        qSort.quickSort(tab,0,tab.length-1);
        assertArrayEquals(new Double[]{},tab);
    }
    @Test
    public void shouldBeOneElement_whenInStartArrIsOnlyOneElement(){
        Double tab [] = {1.00};
        qSort.quickSort(tab,0,tab.length-1);
        assertArrayEquals(new Double[]{1.00},tab);
    }
    @Test
    public void shouldBeCorrectTestedWithTwoElements(){
        Double tab [] = {2.32, 1.2};
        qSort.quickSort(tab,0,tab.length-1);
        assertArrayEquals(new Double[]{1.2, 2.32},tab);
    }
    @Test
    public void shouldBeCorrectTestedWithThreeElements(){
        Double tab [] = {3.21, -2.33, 2.3};
        qSort.quickSort(tab,0,tab.length-1);
        assertArrayEquals(new Double[]{-2.33, 2.3, 3.21},tab);
    }
    @Test
    public void shouldBeNullArr_whenNullArrayIsEnter(){
        Double tab [] = null;
        qSort.quickSort(tab,0,0);
        assertArrayEquals(null,tab);
    }
    @Test
    public void shouldBeCorrectSort_whenRandomArrIsEntered(){
        Double tab [] = rng.getRandomNumbers(10.0, 100.00, 100);
        Double [] tabSortedByJavaLib = tab;
        Arrays.sort(tabSortedByJavaLib);
        qSort.quickSort(tab,0,tab.length-1);
        assertArrayEquals(tabSortedByJavaLib,tab);
    }
    @Test
    public void shouldBeCorrectSort_whenValuesHaveDuplicates(){
        Double tab [] = {1.0  ,1.1  ,1.0    ,5.3    ,0.92   ,0.3};
        qSort.quickSort(tab,0,tab.length-1);
        assertArrayEquals(new Double[]{
                0.3, 0.92, 1.0, 1.0, 1.1, 5.3
        },tab);
    }
}