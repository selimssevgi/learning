package com.durgasoft.keyinterfaces.collectionInterface.setinterface.sortedSetInterface;

import java.util.TreeSet;

/**
 *
 * Created by ssselim on 10/2/16.
 */
public class TreeSetDemo5 {
  public static void main(String[] args) {
    TreeSet<Object> t = new TreeSet<>(new lengthOrder());
    t.add("A");
    t.add(new StringBuffer("ABC"));
    t.add(new StringBuffer("AA"));
    t.add("xx");
    t.add("ABCD");
    t.add("A");
    System.out.println(t);
    System.out.printf("%d", (int) 'A');

  }

  // length increasing order, if same, alphabetical order
  private static class lengthOrder implements java.util.Comparator {
    @Override
    public int compare(Object o1, Object o2) {
      String s1 = o1.toString();
      String s2 = o2.toString();
      int l1 = s1.length();
      int l2 = s2.length();

      if (l1 < l2)
        return -1;
      else if (l1 > l2)
        return +1;
      else
        return s1.compareTo(s2);
    }
  }
}
