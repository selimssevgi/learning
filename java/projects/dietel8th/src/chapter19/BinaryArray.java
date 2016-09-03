package chapter19;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ssselim on 8/7/16.
 */
// contains an array of random generated integers
// and contains binary search to find an integer
public class BinaryArray {
    private int[] data;
    private final static Random generator = new Random();

    public BinaryArray( int size ) {
        data = new int[ size ];

        for (int counter = 0; counter < data.length; counter++) {
            data[ counter ] = 10 + generator.nextInt(90);
        }

        Arrays.sort(data);
    }

    public int binarySearch(int searchKey) {
        int low = 0;
        int high = data.length -1;
        int middle = (low + high + 1) / 2;
        int location = -1;

        do {
            if ( data[ middle ] == searchKey )
                location = middle;
            else if ( data[ middle ] > searchKey )
                high = middle - 1;
            else
                low = middle + 1;

            middle = (low + high + 1) / 2;

        } while ( (low <= high) && (location == -1) );

        return location;
    }

    public String toString() {
        return Arrays.toString(data);
    }
}
