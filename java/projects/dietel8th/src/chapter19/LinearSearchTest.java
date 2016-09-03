package chapter19;

import java.util.Scanner;

/**
 * Created by ssselim on 8/7/16.
 */
public class LinearSearchTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int searchInt;
        int position;

        LinearArray searchArray = new LinearArray( 10 );
        System.out.println( searchArray + "\n" ); // implicit calling of toString

        System.out.print( "Enter number to search, -1 to quit : ");
        searchInt = input.nextInt();

        while ( searchInt != -1 ) {

            position = searchArray.linearSearch(searchInt);

            if (position != -1) {
                System.out.printf("Found at index of %d \n", position);
            } else {
                System.out.println("could not find the number : " + searchInt);
            }

            System.out.print( "Enter number to search, -1 to quit : ");
            searchInt = input.nextInt();
        }
    }
}
