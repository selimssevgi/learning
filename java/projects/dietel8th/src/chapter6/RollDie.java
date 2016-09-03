package chapter6;

import java.util.Random;

/**
 * Created by ssselim on 7/31/16.
 */
public class RollDie
{
    public static void main( String[] args )
    {
        Random random = new Random();
        int[] frequency = new int[ 7 ];

        for ( int counter = 0; counter < 600; counter++ )
        {
            ++frequency[ 1 + random.nextInt(6) ];
        }

        System.out.printf( "%4s%10s\n", "face", "frequency" );


        for ( int counter = 1; counter < frequency.length; counter++ )
        {
            System.out.printf( "%4d%10d\n", counter, frequency[ counter ] );
        }
    }
}
