package chapter2;

import java.util.Scanner;

/**
 * Created by ssselim on 7/24/16.
 */

// display the sum of two of two numbers
public class Addition
{
    public static void main( String[] args )
    {
        // create a scanner to obtain input from the command window
        Scanner input = new Scanner( System.in );

        int number1;
        int number2;
        int sum;

        System.out.print( "Enter first integer: ");
        number1 = input.nextInt();

        System.out.print( "Enter second integer: ");
        number2 = input.nextInt();

        sum = number1 + number2;

        System.out.printf( "Sum is %d\n", sum );
    }
}
