package com.selimssevgi;

import java.util.StringJoiner;

/**
 * Created by ssselim on 9/17/16.
 */
public class StringJoinerEx {
  public static void main(String[] args) {

    // with Separator
    StringJoiner sj = new StringJoiner(", ");
    sj.add("alpha");
    sj.add("theta");
    sj.add("gamma");
    String theResult = sj.toString(); // alpha, theta, gamma
    System.out.println(theResult);

    // chaining method calls
    String anotherResult = sj.add("beta").add("nano").toString();
    System.out.println(anotherResult);

    // with start and end values
    sj = new StringJoiner(", ", "{", "}");
    sj.add("alpha");
    sj.add("theta");
    sj.add("gamma");
    theResult = sj.toString();
    System.out.println(theResult); // {alpha, theta, gamma}

    // with more involved separator
    sj = new StringJoiner("], [", "[", "]");
    sj.add("alpha");
    sj.add("theta");
    sj.add("gamma");
    theResult = sj.toString();
    System.out.println(theResult); // [alpha], [theta], [gamma]

    // customizing Empty Handling
    sj = new StringJoiner(", ");
    sj.setEmptyValue("EMPTY");
    System.out.println(sj.toString()); // EMPTY

    sj = new StringJoiner(", ", "{", "}");
    sj.setEmptyValue("EMPTY");
    System.out.println(sj.toString()); // EMPTY

    sj = new StringJoiner(", ");
    sj.setEmptyValue("EMPTY");
    sj.add("");
    System.out.println(sj); // empty nothing

    sj = new StringJoiner(",", "{", "}");
    sj.setEmptyValue("EMPTY");
    sj.add("");
    System.out.println(sj); // {}
    // Do not add empty string if u dont want them
  }
}
