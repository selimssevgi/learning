package chapter4;

/**
 * Created by ssselim on 7/29/16.
 */

// Do..While repetition statement
public class DoWhileTest
{
    public static void main( String[] args )
    {
        int counter = 1;

        do
        {
            System.out.printf("%d ", counter);
            counter++;
        } while ( counter <= 10);
    }
}
