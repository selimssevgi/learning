package com.selimssevgi;

/**
 * Created by ssselim on 9/17/16.
 */
public class FormattingEx {

  public static void main(String[] args) {
    int david = 13;
    int dawson = 11;
    int dillon = 4;
    int gordon = 2;
    double avg = 3.666666666665;

    // concatenation
    String s1 = "My nephews are " +
            david + ", " + dawson +
            ", " + dillon + ", and " +
            gordon + " years old";
    System.out.println(s1);

    // formatting
    String s2 = String.format(
            "My nephews are %d, %d, %d, and %d years old",
            david, dawson, dillon, gordon);
    System.out.println(s2);

    String s3 = "Average is " + avg;
    System.out.println(s3);

    String s4 = String.format("Average is %.1f", avg);
    System.out.println(s4);

    // Format Flag: #
    String s5 = String.format("%d", 32); // 32
    String s6 = String.format("%o", 32); // 40
    String s7 = String.format("%x", 32); // 20

    String s8 = String.format("%#o", 32); // 040
    String s9 = String.format("%#x", 32); // 0x20
    String s0 = String.format("%#X", 32); // 0X20

    s1 = String.format("W:%d X:%d", 5, 235);  // W:5 X:235
    s2 = String.format("Y:%d Z:%d", 481, 12); // Y:481 Z:12

    // right justify by default
    s3 = String.format("W:%4d X:%4d", 5, 235);  // W:   5 X: 235
    s4 = String.format("Y:%4d Z:%4d", 481, 12); // Y: 481 Z:  12

    // Format Flag: 0 (Zero Padding)
    s5 = String.format("W:%04d X:%04d", 5, 235);  // W:0005 X:0235
    s6 = String.format("Y:%04d Z:%04d", 481, 12); // Y:0481 Z:0012

    // Format Flag: - (Left justify)
    s7 = String.format("W:%-4d X:%-4d", 5, 235);  // W:5    X:235
    s8 = String.format("Y:%-4d Z:%-4d", 481, 12); // Y:481  Z:12

    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
    System.out.println(s4);
    System.out.println(s5);
    System.out.println(s6);
    System.out.println(s7);
    System.out.println(s8);

    // Format Flags: , (Include grouping separator)
    s1 = String.format("%d", 1234567);  // 1234567
    s2 = String.format("%,d", 1234567); // 1,234,567
    s3 = String.format("%,.2f", 1234567.0); // 1,234,567.00
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

    s1 = String.format("%d", 123); // 123
    s2 = String.format("%d", -456); // -456

    // Format Flags: [space] (Leave space for positive numbers/sign)
    s3 = String.format("% d", 123);  //  123
    s4 = String.format("% d", -456); // -456

    // Format Flags: + (Always shown sign)
    s5 = String.format("%+d", 123);  // +123
    s6 = String.format("%+d", -456); // -456

    // Format Flags: ( (Enclose negative values in parenthesis
    s7 = String.format("%(d", 123);  // 123
    s8 = String.format("%(d", -456); // (456)
    s9 = String.format("% (d", 123);  // 123

    // Argument Index
    s1 = String.format("%d %d %d", 100, 200, 300); // 100 200 300
    s2 = String.format("%$3d %$1d %$2", 100, 200, 300); // 300 100 200

  }

}
