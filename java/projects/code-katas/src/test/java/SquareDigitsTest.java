import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ssselim on 8/3/16.
 */
public class SquareDigitsTest {

    @Test
    public void testSquareDigits()
    {
        assertEquals( 8181, SquareDigits.squareDigits(99));
        assertEquals( 1111, SquareDigits.squareDigits(1111));
    }

    @Test
    public void testSquareDigits2()
    {
        assertEquals( 44, SquareDigits.squareDigits2(22) );
    }
}
