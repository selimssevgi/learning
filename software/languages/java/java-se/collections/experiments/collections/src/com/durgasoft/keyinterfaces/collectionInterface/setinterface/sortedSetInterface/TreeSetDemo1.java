package com.durgasoft.keyinterfaces.collectionInterface.setinterface.sortedSetInterface;

import java.util.TreeSet;

/**
 * Created by ssselim on 10/1/16.
 */
public class TreeSetDemo1 {
  public static void main(String[] args) {
    TreeSet<StringBuffer> t = new TreeSet<>(); // default natural sorting order
    t.add(new StringBuffer("B"));
    t.add(new StringBuffer("A"));
    t.add(new StringBuffer("Z"));
    System.out.println(t); // RE: ClassCastException. StringBuffer is not comparable.
  }
}
