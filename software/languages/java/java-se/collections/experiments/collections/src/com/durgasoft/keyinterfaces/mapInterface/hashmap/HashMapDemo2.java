package com.durgasoft.keyinterfaces.mapInterface.hashmap;

import java.util.HashMap;

/**
 * Created by ssselim on 10/2/16.
 */
public class HashMapDemo2 {
  public static void main(String[] args) {
    HashMap<Integer, String> m = new HashMap<>();
    Integer i1 = new Integer(10);
    Integer i2 = new Integer(10);
    m.put(i1, "java");
    m.put(i2, "python");
    System.out.println(m); // {10=python}

    // Because hashmap uses .equals method internally
    // to decide if the key is already available.
    // so it will threat i1 and i2 as same keys.
  }
}
