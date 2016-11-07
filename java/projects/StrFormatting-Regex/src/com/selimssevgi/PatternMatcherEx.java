package com.selimssevgi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ssselim on 9/17/16.
 */
public class PatternMatcherEx {
  public static void main(String[] args) {
    String s1 = "apple, apple and orange please";

    Pattern pattern = Pattern.compile("\\w+");

    Matcher matcher = pattern.matcher(s1);

    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}
