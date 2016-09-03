package chapter18;

import java.math.BigInteger;

/**
 * Created by ssselim on 8/6/16.
 */
public class FibonacciCalculator {

    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static long fibonacci(long number) {
        if ( number == 0 || number == 1 )
            return 1;
        else
            return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static BigInteger fibonacci( BigInteger number ) {
//        if ( number.compareTo(BigInteger.ZERO) == 0 ||
//                number.compareTo(BigInteger.ONE) == 0 )
        if ( number.equals(BigInteger.ONE) ||
                number.equals( BigInteger.ZERO ))
            return BigInteger.ONE;
        else
            return fibonacci(number.subtract(BigInteger.ONE)).add(
                    fibonacci(number.subtract(TWO)) );
    }


    public static void main(String[] args) {

        for (int count = 0; count < 20; count++) {
            System.out.printf(" LONG = %d = %d\n", count, fibonacci(count));
            System.out.printf(" BINT = %d = %d\n", count, fibonacci(BigInteger.valueOf(count)));
        }
    }
}
