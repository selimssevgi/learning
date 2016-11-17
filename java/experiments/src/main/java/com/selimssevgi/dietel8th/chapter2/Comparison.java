package com.selimssevgi.dietel8th.chapter2;

import java.util.Scanner;

/**
 * Created by ssselim on 7/24/16.
 */

// compare integers using relational and equality operators
public class Comparison
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );

        System.out.printf( "%c = %d\n", (char) 65, 65 );

        int number1;
        int number2;
        int sum;

        System.out.print( "Enter first number: " );
        number1 = input.nextInt();

        System.out.print( "Enter second number: " );
        number2 = input.nextInt();

        sum = number1 + number2;


        if ( number1 == number2 )
            System.out.printf( "%d == %d\n", number1, number2 );

        if ( number1 != number2 )
            System.out.printf( "%d != %d\n", number1, number2 );

        if ( number1 > number2 )
            System.out.printf( "%d > %d\n", number1, number2 );

        if ( number1 < number2 )
            System.out.printf( "%d < %d\n", number1, number2 );

        if ( number1 >= number2 )
            System.out.printf( "%d >= %d\n", number1, number2 );

        if ( number1 <= number2 )
            System.out.printf( "%d <= %d\n", number1, number2 );
    }
}
