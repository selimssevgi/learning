package cursors;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Created by ssselim on 10/1/16.
 */
public class CursorsDemo {
  public static void main(String[] args) {
    Vector v = new Vector();
    Enumeration e = v.elements();
    Iterator itr = v.iterator();
    ListIterator litr = v.listIterator();

    System.out.println(e.getClass().getName());    // java.util.Vector$1
    System.out.println(itr.getClass().getName());  // java.util.Vector$Itr
    System.out.println(litr.getClass().getName()); // java.util.Vector$ListItr
  }
}
