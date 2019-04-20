package com.durgasoft.keyinterfaces.collectionInterface.setinterface;

import java.util.HashSet;

/**
 * Created by ssselim on 10/1/16.
 */
public class HashSetDemo {
  public static void main(String[] args) {
    HashSet<String> hashSet = new HashSet<>();

    hashSet.add("B");
    hashSet.add("C");
    hashSet.add("D");
    hashSet.add("E");
    hashSet.add(null);
    System.out.println(hashSet.add("E")); // false
    System.out.println(hashSet); // we dont know the other of printing

  }
}
