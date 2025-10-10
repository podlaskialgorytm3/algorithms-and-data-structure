package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    public Sorter [] sorters = new Sorter [] {new InsertionSort(), new QuickSort()};
    public RandomNumberGenerator rng = new RandomNumberGenerator();

    @Test
    void shouldBeEmpty_whenEmptyArrayIsEntered(){
        for(Sorter sorter : sorters){
            Double [] data = new Double[]{};
            sorter.sort(data);
            assertArrayEquals(new Double[]{},data);
        }
    }
    @Test
    void shouldNotThrow_whenNullArrayIsEntered() {
        for (Sorter sorter : sorters) {
            Double [] data = null;
            sorter.sort(data);
            assertArrayEquals(null,data);
        }
    }
    @Test
    void shouldBeOneElement_whenOneElementIsEntered(){
        for(Sorter sorter : sorters){
            Double [] data = new Double[]{1.0};
            sorter.sort(data);
            assertArrayEquals(new Double[]{1.0},data);
        }
    }
    @Test
    void shouldBeTwoElements_whenTwoElementIsEntered(){
        for(Sorter sorter : sorters){
            Double [] data = new Double[]{1.0,0.5};
            sorter.sort(data);
            assertArrayEquals(new Double[]{0.5,1.0},data);
        }
    }
    @Test
    void shouldBeThreeElements_whenThreeElementIsEntered(){
        for(Sorter sorter : sorters){
            Double [] data = new Double[]{1.0,0.5,2.0};
            sorter.sort(data);
            assertArrayEquals(new Double[]{0.5,1.0,2.0},data);
        }
    }
    @Test
    void shouldBeSorte_whenNegativeElementIsEntered(){
        for(Sorter sorter : sorters){
            Double [] data = new Double[]{-1.0,-0.5,-2.0};
            sorter.sort(data);
            assertArrayEquals(new Double[]{-2.0,-1.0,-0.5},data);
        }
    }
    @Test
    void shouldBeSorted_whenDuplicatedElementsAreEntered(){
        for(Sorter sorter : sorters){
            Double [] data = new Double[]{3.0,1.0,1.0,2.0};
            sorter.sort(data);
            assertArrayEquals(new Double[]{1.0,1.0,2.0,3.0},data);
        }
    }
    @Test
    void shouldBeSorted_whenRandomNumbersAreEntered(){
        for(Sorter sorter : sorters){
            Double [] data = rng.getRandomNumbers(-1000.00,1000.00, 1000);
            Double [] dataSortedByAlgorithm = Arrays.copyOf(data, data.length);
            Double [] dataSortedByJava = Arrays.copyOf(data, data.length);
            sorter.sort(dataSortedByAlgorithm);
            sorter.sort(dataSortedByJava);
            assertArrayEquals(dataSortedByAlgorithm,dataSortedByJava);
        }
    }

}