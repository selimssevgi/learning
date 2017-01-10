package com.durgasoft.keyinterfaces.collectionInterface.setinterface.sortedSetInterface;

import java.util.TreeSet;

/**
 * Created by ssselim on 10/2/16.
 */
public class TreeSetDemo4 {
  public static void main(String[] args) {
    //TreeSet<String> t = new TreeSet<>(); // natural string order, alphabetical
    TreeSet<String> t = new TreeSet<>(new ReverseAlphaOrder());
    t.add("java");
    t.add("oracle");
    t.add("android");
    t.add("collection");
    System.out.println(t);
  }

  private static class ReverseAlphaOrder implements java.util.Comparator {
    @Override
    public int compare(Object o1, Object o2) {
      String s1 = (String) o1;
      String s2 = (String) o2;
      return -s1.compareTo(s2);
    }
  }
}
