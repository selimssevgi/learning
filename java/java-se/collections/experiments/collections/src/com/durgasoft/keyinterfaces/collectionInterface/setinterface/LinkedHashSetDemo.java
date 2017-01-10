package com.durgasoft.keyinterfaces.collectionInterface.setinterface;

import java.util.LinkedHashSet;

/**
 * Created by ssselim on 10/1/16.
 */
public class LinkedHashSetDemo {
  public static void main(String[] args) {
    LinkedHashSet<String> lhs = new LinkedHashSet<>();
    lhs.add("A");
    lhs.add("b");
    lhs.add("C");
    lhs.add("D");
    lhs.add(null);
    System.out.println(lhs); // preserves the insertion order
  }
}
