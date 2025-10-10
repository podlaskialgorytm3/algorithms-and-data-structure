package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    public Sorter [] sorters = new Sorter [] {new InsertionSort(), new QuickSort()};

    @Test
    void shouldBeEmpty_whenEmptyArrayIsEntered(){
        for(Sorter sorter : sorters){
            Double [] data = new Double[]{};
            sorter.sort(data);
            assertArrayEquals(new Double[]{},data);
        }
    }

}