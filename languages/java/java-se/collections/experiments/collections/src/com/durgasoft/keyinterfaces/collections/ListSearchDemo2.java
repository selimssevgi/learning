package com.durgasoft.keyinterfaces.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ssselim on 10/3/16.
 */
public class ListSearchDemo2 {
  public static void main(String[] args) {
    ArrayList<Integer> l = new ArrayList<>();
    l.add(15);
    l.add(0);
    l.add(20);
    l.add(10);
    l.add(5);
    System.out.println(l); // [15, 0, 20, 10, 5]
    Collections.sort(l, new MyComparator());
    System.out.println(l); // [20, 15, 10, 5, 0]
    System.out.println(Collections.binarySearch(l, 10, new MyComparator())); // 2
    System.out.println(Collections.binarySearch(l, 13, new MyComparator())); //-3
    System.out.println(Collections.binarySearch(l, 17)); // -6, unpredictable result
    System.out.println(Collections.binarySearch(l, 17, new MyComparator())); //-2
  }

  private static class MyComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
      Integer i1 = (Integer) o1;
      Integer i2 = (Integer) o2;
      return i2.compareTo(i1); // reverse
    }
  }
}
