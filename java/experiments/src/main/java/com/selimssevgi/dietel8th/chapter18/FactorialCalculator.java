package com.selimssevgi.dietel8th.chapter18;

import java.math.BigInteger;

/**
 * Created by ssselim on 8/6/16.
 */
public class FactorialCalculator {

    // iterative
    public static long factorialIterative( long number ) {
        long result = 1;

        for (long counter = number ; counter > 1 ; counter--) {
            result *= counter;
        }

        return result;
    }

    // recursive
    public static long factorial(long number) {
        if ( number <= 1 )
            return 1;
        else
            return number * factorial( number - 1 );
    }

    public static BigInteger factorial(BigInteger number) {
        if ( number.compareTo(BigInteger.ONE) <=0 )
            return BigInteger.ONE;
        else
            return number.multiply(
                    factorial( number.subtract( BigInteger.ONE ) ) );
    }


    public static void main(String[] args) {
        long number = 5;
        System.out.printf("Iterative : %d! = %d\n", number, factorialIterative(number));
        System.out.printf("%d! = %d\n", 5, factorial(5));
        System.out.printf("%d! = %d\n", 5, factorial( BigInteger.valueOf(50) ) );
    }
}
