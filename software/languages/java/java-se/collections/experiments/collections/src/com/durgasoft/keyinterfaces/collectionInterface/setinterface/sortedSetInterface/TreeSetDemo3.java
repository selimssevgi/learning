package com.durgasoft.keyinterfaces.collectionInterface.setinterface.sortedSetInterface;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by ssselim on 10/1/16.
 */
public class TreeSetDemo3 {
  public static void main(String[] args) {
    //TreeSet<Integer> t = new TreeSet<>(); // natural order, ascending, 0,5,10..
    TreeSet<Integer> t = new TreeSet<>(new MyComparator());
    t.add(10);
    t.add(0);
    t.add(15);
    t.add(5);
    t.add(20);
    t.add(20);
    System.out.println(t);
  }
}

// descending order of integer
// greater number comes first
class MyComparator implements Comparator{

  @Override
  public int compare(Object o1, Object o2) {
    Integer i1 = (Integer) o1;
    Integer i2 = (Integer) o2;

    // return i1.compareTo(i2); // default natural sorting order, ascending
    // return i2.compareTo(i1); // descending order
    // return -i2.compareTo(i1); // ascending order
    // return +1; // insertion order, keeps the duplicate too
    // return -1; // reverse of insertion order
    // return 0; // only first element will be inserted
    return -i1.compareTo(i2); // descending order
//    if (i1 > i2)
//      return -1;
//    else if (i1 < i2)
//      return +1;
//    else
//      return 0;
  }
}
