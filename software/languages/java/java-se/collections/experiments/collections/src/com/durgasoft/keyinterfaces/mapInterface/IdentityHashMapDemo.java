package com.durgasoft.keyinterfaces.mapInterface;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;

/**
 * Created by ssselim on 10/2/16.
 */
public class IdentityHashMapDemo {
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

    IdentityHashMap<Integer, String> m1 = new IdentityHashMap<>();
    Integer i3 = new Integer(10);
    Integer i4 = new Integer(10);
    m1.put(i3, "java");
    m1.put(i4, "python");
    System.out.println(m1); // {10=python, 10=java}

    // it uses == operator for comparison so i3 and i4 are different
  }
}
