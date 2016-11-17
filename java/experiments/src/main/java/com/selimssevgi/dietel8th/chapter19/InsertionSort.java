package com.selimssevgi.dietel8th.chapter19;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ssselim on 8/7/16.
 */
public class InsertionSort {
    private int[] data;
    private final static Random generator = new Random();

    public InsertionSort( int size ) {
        data = new int[ size ];

        for (int counter = 0; counter < data.length; counter++) {
            data[ counter ] = 10 + generator.nextInt(90);
        }
    }

    public void sort() {

        for (int index = 1; index < data.length; index++) {
            int insertElement = data[index];
            int emptySpotIndex = index;

            while ( emptySpotIndex > 0 && insertElement < data[emptySpotIndex-1]) {
                data[emptySpotIndex] = data[emptySpotIndex-1];
                emptySpotIndex--;
            }

            data[emptySpotIndex] = insertElement;

        }
    }

    public String toString() {
        return Arrays.toString(data);
    }
}
