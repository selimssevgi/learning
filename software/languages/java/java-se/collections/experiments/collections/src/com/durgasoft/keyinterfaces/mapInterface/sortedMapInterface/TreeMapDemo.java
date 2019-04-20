package com.durgasoft.keyinterfaces.mapInterface.sortedMapInterface;

import java.util.TreeMap;

/**
 * Created by ssselim on 10/2/16.
 */
public class TreeMapDemo {
  public static void main(String[] args) {
    TreeMap<Integer, String> m = new TreeMap<>();
    m.put(100, "java");
    m.put(103, "oracle");
    m.put(101, "sun");
    //m.put(null, "selim"); NPE
    System.out.println(m); // {100=java, 101=sun, 103=oracle}
  }
}
