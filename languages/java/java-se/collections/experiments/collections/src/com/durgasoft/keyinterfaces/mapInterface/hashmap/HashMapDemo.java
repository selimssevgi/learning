package com.durgasoft.keyinterfaces.mapInterface.hashmap;

import java.util.*;

/**
 * Created by ssselim on 10/2/16.
 */
public class HashMapDemo {

  public static void main(String[] args) {
    //HashMap<String, Integer> m = new HashMap<>(); // insertion order is not preserved
    HashMap<String, Integer> m = new LinkedHashMap<>(); // insertion order is preserved.
    m.put("java", 1995);
    m.put("google", 1997);
    m.put("selim", 1992);
    m.put("oracle", 2010);
    System.out.println(m); // {java=1995, oracle=2010, google=1997, selim=1992}
    System.out.println(m.put("java", 1994)); // returns old value, 1995

    Set s = m.keySet();
    System.out.println(s); // [java, oracle, google, selim]

    Collection c = m.values();
    System.out.println(c); // [1994, 2010, 1997, 1992]

    Set entries = m.entrySet();
    System.out.println(entries); // [java=1994, oracle=2010, google=1997, selim=1992]

    Iterator itr = entries.iterator();
    while (itr.hasNext()) {
      Map.Entry e1 = (Map.Entry) itr.next();
      System.out.println(e1.getKey() + "=" + e1.getValue());
      if (e1.getKey().equals("selim")) {
        e1.setValue(2016);
      }
    }
    System.out.println(m); // {java=1994, oracle=2010, google=1997, selim=2016}
  }
}
