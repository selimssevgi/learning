package com.durgasoft.keyinterfaces.collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ssselim on 10/3/16.
 */
public class ListSearchDemo {
  public static void main(String[] args) {
    ArrayList<String> l = new ArrayList<>();
    l.add("Z");
    l.add("A");
    l.add("M");
    l.add("K");
    l.add("a");
    System.out.println(l); // [Z, A, M, K, a]
    Collections.sort(l);   // without this step, we will get unpredictable results.
    System.out.println(l); // [A, K, M, Z, a]
    System.out.println(Collections.binarySearch(l, "Z")); // 3
    System.out.println(Collections.binarySearch(l, "J")); // -2,
  }
}
