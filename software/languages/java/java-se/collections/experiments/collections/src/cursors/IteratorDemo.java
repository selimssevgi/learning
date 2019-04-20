package cursors;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ssselim on 10/1/16.
 */
public class IteratorDemo {
  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      al.add(i);
    }

    System.out.println(al); // print all the elements
    // i want to print just even numbers and remove odd numbers
    Iterator<Integer> itr = al.iterator();
    while (itr.hasNext()) {
      Integer i = itr.next();
      if (i % 2 == 0) {
        System.out.println(i);
      } else {
        itr.remove();
      }
    }

    System.out.println(al); // print even elements
  }
}
