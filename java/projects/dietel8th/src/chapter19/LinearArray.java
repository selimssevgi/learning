package chapter19;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ssselim on 8/7/16.
 */

// contains an array of random generated integers
// and a method searching array sequentially
public class LinearArray {
    private int[] array;
    private final static Random generator = new Random();

    public LinearArray( int size ) {
       array = new int[ size ];

        for (int counter = 0; counter < array.length; counter++) {
            array[ counter ] = 10 + generator.nextInt( 99 ); // 10-99
        }
    }

    // if searchKey is in the array, return the index of it
    // otherwise return -1
    public int linearSearch( int searchKey ) {

        for (int index = 0; index < array.length; index++) {
           if ( array[ index ] == searchKey )
               return index;
        }
        return -1;
    }


    public String toString() {
        return Arrays.toString(array);
    }


}
