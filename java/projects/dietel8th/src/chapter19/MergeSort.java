package chapter19;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ssselim on 8/7/16.
 */
public class MergeSort {
    private int[] data;
    private final static Random generator = new Random();

    public MergeSort( int size ) {
        data = new int[ size ];

        for (int counter = 0; counter < data.length; counter++) {
            data[ counter ] = 10 + generator.nextInt(90);
        }
    }

    public void sort() {
        sortArray( 0, data.length - 1 );
    }

    private void sortArray(int low, int high) {

        if ( (high - low) >= 1 ) { // if not the base case
            int middle1 = (low + high) / 2;
            int middle2 = middle1 + 1;

            //output split step
            System.out.println( "split : " + subArray( low, high ) );
            System.out.println( "        " + subArray( low, middle1 ) );
            System.out.println( "        " + subArray( middle2, high ) );
            System.out.println();

            // split array in half, sort them recursively
            sortArray( low, middle1 );
            sortArray( middle2, high );

            // merge two sorted subarrays into one sorted subarray
            merge( low, middle1, middle2, high );
        }
    }

    private void merge(int left, int middle1, int middle2, int right) {
        int leftIndex = left;
        int rightIndex = middle2;
        int combinedIndex = left;
        int[] combined = new int[ data.length ];

        // output two subarrays before merging
        System.out.println("Merge :   " + subArray( left, middle1 ));
        System.out.println("          " + subArray( middle2, right ));

        while ( leftIndex <= middle1 && rightIndex <= right ) {
            // place smaller of two current elements into result
            // and move to next space in arrays
            if ( data[leftIndex] < data[rightIndex] )
                combined[ combinedIndex++ ] = data[ leftIndex++ ];
            else
                combined[ combinedIndex++ ] = data[ rightIndex++ ];
        }

        if ( leftIndex == middle2 )
            while ( rightIndex <= right )
                combined[ combinedIndex++ ] = data[ rightIndex++ ];
        else
            while ( leftIndex <= middle1 )
                combined[ combinedIndex++ ] = data[ leftIndex++ ];

        for (int i = left; i <= right; i++)
            data[i] = combined[i];


        System.out.println("        " + subArray( left, right ));
        System.out.println();
    }

    private String subArray(int low, int high) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < low; i++) {
            sb.append( "   " );
        }

        for (int i = low; i <= high; i++) {
            sb.append( " " + data[i] );
        }

        return sb.toString();
    }

    public String toString() {
        return Arrays.toString(data);
    }
}
