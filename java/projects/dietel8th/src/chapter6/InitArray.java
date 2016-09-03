package chapter6;

/**
 * Created by ssselim on 7/31/16.
 */
public class InitArray
{
    public static void main( String[] args )
    {
//        int[] array; // declare array named array
//        array = new int[ 10 ]; // create the array object
        int[] array = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };

        System.out.printf( "%s%8s\n", "Index", "Value");

        for ( int counter = 0; counter < array.length; counter++ )
        {
            System.out.printf( "%5d%8d\n", counter, array[ counter ]);
        }

        int sum = 0;

        for ( int counter = 0; counter < array.length; counter++ )
        {
            sum += array[ counter ];
        }

        System.out.printf("Total of array elements %d\n", sum );
    }
}
