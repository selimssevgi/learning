package selimssevgi.tdd;

import com.selimssevgi.tdd.LeapYear;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ssselim on 10/18/16.
 */
public class LeapYearTest {

  // a year is a leap year if it is divisible by four
  // but years divisible by 100, are not leap year.
  // except years divisible by 400.

  @Test
  public void leapYearsAreDivisibleByFour() {
    assertTrue(LeapYear.isLeapYear(2016));
  }

  @Test
  public void normalYearsAreNotDivisibleByFour() {
    assertFalse(LeapYear.isLeapYear(3));
  }

  @Test
  public void leapYearsAreNotDivisibleByOneHundred() {
    assertFalse(LeapYear.isLeapYear(1900));
  }

  @Test
  public void leapYearsAreDivisibleByFourHundred() {
    assertTrue(LeapYear.isLeapYear(2000));
  }
}
