package com.selimssevgi.tdd;

/**
 * Created by ssselim on 10/18/16.
 */
public class LeapYear {
  public static boolean isLeapYear(int year) {
    return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year, 400));
  }

  private static boolean isDivisible(int year, int denominator) {
    return year % denominator == 0;
  }
}
