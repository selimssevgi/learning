package chapter19;

import java.util.Scanner;

/**
 * Created by ssselim on 8/7/16.
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryArray searchArray = new BinaryArray( 10 );
        int searchInt;
        int position;

        System.out.println( searchArray + "\n");

        System.out.print("Enter a number to search, -1 to quit : ");
        searchInt = input.nextInt();

        while ( searchInt != -1 ) {

            position = searchArray.binarySearch( searchInt );

            if ( position != -1 )
                System.out.printf("Found at %d\n", position);
            else
                System.out.println("Couldnt find the number : " + searchInt);


            System.out.print("Enter a number to search, -1 to quit : ");
            searchInt = input.nextInt();

        }
    }
}
