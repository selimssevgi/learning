package com.durgasoft.keyinterfaces.collectionInterface.queueInterface;

import java.util.PriorityQueue;

/**
 * Created by ssselim on 10/3/16.
 */
public class PriorityQueueDemo {
  public static void main(String[] args) {
    PriorityQueue<String> pq = new PriorityQueue<>();
    System.out.println(pq.peek()); // no elements, null
    //System.out.println(pq.element()); // no elements, RE: NPE

    for (int i = 0; i < 10; i++) {
      pq.offer(i + "");
    }

    System.out.println(pq); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    System.out.println(pq.poll()); // 0
    System.out.println(pq);
    // output is different cus platform doesnt provide proper support for priority.
    System.out.println(pq); // [1, 3, 2, 7, 4, 5, 6, 9, 8]
  }
}
