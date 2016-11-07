package com.durgasoft.keyinterfaces.collectionInterface.setinterface.sortedSetInterface;

import java.util.TreeSet;

/**
 * Created by ssselim on 10/1/16.
 */
public class TreeSetDemo {
  public static void main(String[] args) {
    TreeSet<String> t = new TreeSet<>(); // default natural sorting order
    t.add(null); // not allowed!
    t.add("A");
    t.add("a");
    t.add("B");
    t.add("Z");
    t.add("L");
    //t.add(null); // not allowed!
    System.out.println(t); // [A, B, L, Z, a]
  }
}
