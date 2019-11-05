package com.in28minutes.junit.helper;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArraysCompareTest {

    @Test
    public void testArray(){
        int[] numbers = {15, 3, 4, 1};
        int[] sorted = {15, 3, 4, 1};
        assertArrayEquals(sorted, numbers);
    }
    @Test(expected = NullPointerException.class)
    public void test() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }

    @Test(timeout = 100)
    public void testSortPerformance(){
        int[] array = {12, 23, 4};
        for (int i = 1; i < 1000000; i++){
            array[0] = i;
            Arrays.sort(array);
        }
    }

}
