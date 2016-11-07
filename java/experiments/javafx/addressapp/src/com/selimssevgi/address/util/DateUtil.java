package com.selimssevgi.address.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Helper functions for handling dates
 * Created by ssselim on 9/27/16.
 */
public class DateUtil {
  // the date pattern that is used for conversion
  private static final String DATE_PATTERN = "dd.MM.yyyy";

  // date formatter
  private static final DateTimeFormatter DATE_FORMATTER =
          DateTimeFormatter.ofPattern(DATE_PATTERN);

  /**
   * Returns the given date as well formatted String.
   * The above defined DATE_PATTERN is used.
   *
   * @param date the date to be returned as a string
   * @return formatted string
   */
  public static String format(LocalDate date) {
    if (date == null) {
      return null;
    }
    return DATE_FORMATTER.format(date);
  }

  /**
   * Converts a String in the format of the defined patter
   * to a LocalDate object.
   *
   * Returns null if the String could not be converted.
   *
   * @param dateString the date as String
   * @return the date object or nill if it could not be converted
   */
  public static LocalDate parse(String dateString) {
    try {
      return DATE_FORMATTER.parse(dateString, LocalDate::from);
    } catch (DateTimeParseException e) {
      return null;
    }
  }

  /**
   * Checks the String whether is it a valid date.
   *
   * @param dateString
   * @return true if the String is a valid date
   */
  public static boolean validDate(String dateString) {
    return DateUtil.parse(dateString) != null;
  }
}
