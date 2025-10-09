package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ISortTest {
    private ISort sort = new ISort();
    private RandomNumberGenerator rng = new RandomNumberGenerator();

    @Test
    public void shouldBeEmpty_whenEmptyArrayIsEnter(){
        Double tab [] = new Double[]{};
        sort.insertionSort(tab);
        assertArrayEquals(new Double[]{},tab);
    }
    @Test
    public void shouldBeNull_whenEmptyArrayIsEnter(){
        Double tab [] = null;
        sort.insertionSort(tab);
        assertArrayEquals(null,tab);
    }
    @Test
    public void shouldBeOneElement_whenInArrayOneElementIsEnter(){
        Double tab [] = new Double[]{1.0};
        sort.insertionSort(tab);
        assertArrayEquals(new Double[]{1.0},tab);
    }
    @Test
    public void shouldBeSortedTwoElements_whenInArrayTwoElementIsEnter(){
        Double tab [] = new Double[]{2.0,1.0};
        sort.insertionSort(tab);
        assertArrayEquals(new Double[]{1.0, 2.0},tab);
    }
    @Test
    public void shouldBeSortedThreeElements_whenInArrayThreeElementIsEnter(){
        Double tab [] = new Double[]{2.0,3.0,1.0};
        sort.insertionSort(tab);
        assertArrayEquals(new Double[]{1.0, 2.0, 3.0},tab);
    }
    @Test
    public void shouldBeSorted_whenInArrayAreDuplicateElements(){
        Double tab [] = new Double[]{1.0,1.0,2.0,3.0,1.0,2.0,3.0,0.5,1.5};
        sort.insertionSort(tab);
        assertArrayEquals(new Double[]{0.5,1.0,1.0,1.0,1.5,2.0,2.0,3.0,3.0}, tab);
    }
    @Test
    public void shouldBeSorted_whenInArrayAreNegativeElements(){
        Double tab [] = new Double[]{-1.0,-2.0,-3.0,1.0};
        sort.insertionSort(tab);
        assertArrayEquals(new Double[]{-3.0,-2.0,-1.0,1.0},tab);
    }
    @Test
    public void shouldBeSorted_whenInArrayAreRandomElements(){
        RandomNumberGenerator rng = new RandomNumberGenerator();
        Double [] tab = rng.getRandomNumbers(-100.00, 200.00, 100);
        Double [] tabSortedByInsetionSort = Arrays.copyOf(tab,tab.length);
        Double [] tabSortedByJavaUtil = Arrays.copyOf(tab,tab.length);
        Arrays.sort(tabSortedByJavaUtil);
        sort.insertionSort(tabSortedByInsetionSort);
        assertArrayEquals(tabSortedByJavaUtil,tabSortedByInsetionSort);

    }
}