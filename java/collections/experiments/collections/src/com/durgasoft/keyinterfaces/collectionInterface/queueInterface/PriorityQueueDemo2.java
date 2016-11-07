package com.durgasoft.keyinterfaces.collectionInterface.queueInterface;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ssselim on 10/3/16.
 */
public class PriorityQueueDemo2 {
  public static void main(String[] args) {
    PriorityQueue<String> q = new PriorityQueue<>(15, new AComparator());
    q.offer("A");
    q.offer("Z");
    q.offer("L");
    q.offer("B");
    System.out.println(q); // [Z, B, L, A]
  }

  private static class AComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
      String s1 = (String) o1;
      String s2 = (String) o2;
      return s2.compareTo(s1);
    }
  }
}
