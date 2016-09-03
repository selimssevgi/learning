import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ssselim on 8/3/16.
 */
public class SmallestIntegerFinderTest {

    @Test
    public void testEmptyArray()
    {
        int[] emptyArray = { };

        assertEquals( -1, SmallestIntegerFinder.findSmallestInt( emptyArray ));
    }

    @Test
    public void testFindSmallestInt()
    {
        int[] arr1 = { 34, 15, 88, 2 };

        assertEquals( 2, SmallestIntegerFinder.findSmallestInt( arr1 ));
    }

    @Test
    public void testNegativeMin()
    {
        int expected = -33;
        int actual = SmallestIntegerFinder.findSmallestInt(new int[]{ 10, -4, 53, -33});
        assertEquals( expected, actual);
    }

    @Test
    public void testMinInteger()
    {
        int expected = Integer.MIN_VALUE;
        int actual = SmallestIntegerFinder.findSmallestInt(new int[]{ Integer.MIN_VALUE, Integer.MAX_VALUE });
        assertEquals( expected, actual );
    }
}
