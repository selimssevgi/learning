package com.durgasoft.keyinterfaces.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ssselim on 10/3/16.
 */
public class ArraySortDemo {
  public static void main(String[] args) {
    int[] a = { 10, 5, 20, 11, 6};

    System.out.println("Primitive array before sorting: ");
    printArr(a); // 10 5 20 11 6

    Arrays.sort(a);

    System.out.println("Primitive array after sorting:");
    printArr(a); // 5 6 10 11 20

    String[] s = {"A", "Z", "B"};

    System.out.println("String array before sorting: ");
    printArr(s); // A Z B

    Arrays.sort(s);

    System.out.println("String arr after sorting: ");
    printArr(s); // A B Z

    Arrays.sort(s, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o2.compareTo(o1);
      }
    });

    System.out.println("String array after sorting by comparator:");;
    printArr(s); // Z B A
  }

  private static void printArr(String[] arr) {
    for (String s : arr) {
      System.out.print(s + " ");
    }
    System.out.println();
  }

  private static void printArr(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

}
