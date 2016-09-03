package chapter6;

/**
 * Created by ssselim on 7/31/16.
 */
public class VarargsTest
{
    public static void main( String[] args )
    {
        double d1 = 10.0;
        double d2 = 20.0;
        double d3 = 30.0;
        double d4 = 40.0;

        System.out.printf(" d1 = %.1f\n d2 = %.1f\n d3 = %.1f\n d4 = %.1f\n",
                d1, d2, d3, d4);

        System.out.printf( "Average of d1 and d2 is %.1f\n",
                average( d1, d2 ) );
        System.out.printf( "Average of d1, d2 and d3 is %.1f\n",
                average( d1, d2, d3 ) );
        System.out.printf( "Average of d1, d2, d3 and d4 is %.1f\n",
                average( d1, d2, d3, d4 ) );
    }

    private static double average(double... numbers) {
        double average = 0;
        double total = 0;

        for ( double number : numbers )
        {
            total += number;
        }

        average = total / numbers.length;

        return average;
    }
}
