package com.selimssevgi.dietel8th.chapter19;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ssselim on 8/7/16.
 */
public class SelectionSort {
    private int[] data;
    private final static Random generator = new Random();

    public SelectionSort( int size ) {
       data = new int[ size ];

        for (int counter = 0; counter < data.length; counter++) {
            data[ counter ] = 10 + generator.nextInt(90);
        }
    }

    public void sort() {

        for (int i = 0; i < data.length - 1; i++) {
            int smallest = i;

            for (int j = i+1; j < data.length ; j++)
            {
                if ( data[ smallest ] > data[ j ])
                    smallest = j;
            }
            swap( i, smallest );
        }
    }

    private void swap(int a, int b) {
        int temp  = data[ a ];
        data[ a ] = data[ b ];
        data[ b ] = temp;
    }

    public String toString() {
        return Arrays.toString(data);
    }
}
