package cursors;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by ssselim on 10/1/16.
 */
public class EnumerationDemo {
  public static void main(String[] args) {
    Vector<Integer> v = new Vector<>();
    for (int i = 0; i < 10; i++) {
      v.addElement(i);
    }
    System.out.println(v); // print all the elements

    // I want to print just even numbers in the collection
    Enumeration<Integer> e = v.elements();
    while (e.hasMoreElements()) {
      Integer i = e.nextElement();
      if (i % 2 == 0) {
        System.out.println(i);
      }
    }
  }
}
