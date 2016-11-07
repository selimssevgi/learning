package com.durgasoft.keyinterfaces.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ssselim on 10/3/16.
 */
public class ListSortDemo {
  public static void main(String[] args) {
    ArrayList<String> l = new ArrayList<>();
    l.add("Z");
    l.add("A");
    l.add("K");
    l.add("N");
    // l.add(null); // RE: NPE

    System.out.println("Before sorting: " + l); // Before sorting: [Z, A, K, N]
    Collections.sort(l); // d.n.s.o
    System.out.println("After sorting: " + l); // After sorting: [A, K, N, Z]
    Collections.sort(l, new ReverseComparator());
    System.out.println("After customized sorting: " + l); // After customized sorting: [Z, N, K, A]
  }

  private static class ReverseComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
      String s1 = (String) o1;
      String s2 = (String) o2;
      return s2.compareTo(s1);
    }
  }
}
