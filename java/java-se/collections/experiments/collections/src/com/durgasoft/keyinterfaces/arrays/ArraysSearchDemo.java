package com.durgasoft.keyinterfaces.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ssselim on 10/3/16.
 */
public class ArraysSearchDemo {
  public static void main(String[] args) {
    int[] intArr = {10, 5, 20, 11, 6};
    System.out.println("initial: " + Arrays.toString(intArr));
    Arrays.sort(intArr);
    System.out.println("sorted: " + Arrays.toString(intArr));
    System.out.println(Arrays.binarySearch(intArr, 6)); // 1
    System.out.println(Arrays.binarySearch(intArr, 14)); // -5

    String[] s = {"A", "Z", "B"};
    System.out.println("initial: " + Arrays.toString(s));
    Arrays.sort(s);
    System.out.println("Sorted: " + Arrays.toString(s));
    System.out.println(Arrays.binarySearch(s, "Z")); // 2
    System.out.println(Arrays.binarySearch(s, "S")); // -3

    Comparator myComparator = new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;
        return s2.compareTo(s1); // reverse of alpha
      }
    };

    Arrays.sort(s, myComparator);
    System.out.println("Customized Sorted: " + Arrays.toString(s));
    System.out.println(Arrays.binarySearch(s, "Z", myComparator)); // 0
    System.out.println(Arrays.binarySearch(s, "S", myComparator)); // -2
    System.out.println(Arrays.binarySearch(s, "N")); // unpredictable result!!
  }
}
