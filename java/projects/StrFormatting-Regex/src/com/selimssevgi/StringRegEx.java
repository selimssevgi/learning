package com.selimssevgi;

/**
 * Created by ssselim on 9/17/16.
 */
public class StringRegEx {
  public static void main(String[] args) {
    String s1 = "apple, apple and orange please";

    // change word apple to appricot

    String s2 = s1.replaceAll("ple", "ricot");
    System.out.println(s2); // also changes please

    // escaping \ , \b word break
    String s3 = s1.replaceAll("ple\\b", "ricot");
    System.out.println(s3);

    String[] parts = s1.split("\\b"); // contains space and comma
    for (String part:parts) {
//      System.out.println(part);
      if (part.matches("\\w+")) { // excludes space and comma
        System.out.println(part);
      }
    }
  }
}
