import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ssselim on 8/3/16.
 */
public class MyUnitTest {

    @Test
    public void testConcatenate()
    {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate( "one", "two" );

        assertEquals( "onetwo", result );
    }

    @Test
    public void testGetTheStringArray()
    {
        MyUnit myUnit = new MyUnit();

        String[] expectedArray = { "one", "two", "three" };

        String[] resultArray = myUnit.getTheStringArray();

        assertArrayEquals( expectedArray, resultArray );
    }

    @Test
    public void testGetBoolean()
    {
        MyUnit myunit = new MyUnit();

        assertTrue( myunit.getBooleanTrue() );
        assertFalse( myunit.getBoolenFalse() );
    }

    @Test
    public void testGetTheObject()
    {
        MyUnit myunit = new MyUnit();

        assertNull( myunit.getNullObject() );

        assertNotNull( myunit.getNotNullObject() );
    }
















}
