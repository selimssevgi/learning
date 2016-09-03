package chapter6;

/**
 * Created by ssselim on 7/31/16.
 */
public class PassArray
{
    public static void main( String[] args )
    {
        int[] array = { 1, 2, 3, 4, 5 };

        System.out.print(
                        "Effects of passing reference to entire array:\n" +
                        "The values of the original array: "
        );

        for ( int value: array )
        {
            System.out.printf(" %d", value);
        }

        modifyArray( array );
        System.out.println("\nThe values of modified array: ");

        for ( int value: array )
        {
            System.out.printf(" %d", value);
        }

        System.out.printf(
                "\nEffects of passing array element value:\n" +
                        "array[3] before modifyElement: %d\n ", array[ 3 ]
        );

        modifyElement( array[ 3 ] );
        System.out.printf("\narray[3] after modifyElement : %d", array[3]);
    }

    private static void modifyElement( int element ) {

        element *= 2;
        System.out.printf("\nElement in modifyElement : %d\n", element );
    }


    private static void modifyArray(int[] array) {
        for (int counter = 0; counter < array.length; counter++) {
           array[ counter ] *= 2;
        }
    }
}
