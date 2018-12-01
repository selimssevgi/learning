package com.durgasoft.keyinterfaces.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ssselim on 10/3/16.
 */
public class ArraysAsListDemo {
  public static void main(String[] args) {
    String[] s = { "A", "Z", "B" };
    List l = Arrays.asList(s);
    System.out.println(l); // [A, Z, B]
    s[0] = "K";
    System.out.println(l); // [K, Z, B]
    l.set(1, "L");
    System.out.println("Array: " + Arrays.toString(s)); // Array: [K, L, B]
    //l.add("durga"); // UsOE
    //l.remove(2); // UsOE
    //l.set(1, new Integer(10)); // ArrayStoreException
  }
}
