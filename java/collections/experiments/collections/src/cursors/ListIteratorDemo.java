package cursors;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by ssselim on 10/1/16.
 */
public class ListIteratorDemo {
  public static void main(String[] args) {
    LinkedList<String> ll = new LinkedList<>();
    ll.add("java");
    ll.add("sun");
    ll.add("james gosling");
    System.out.println(ll); // [java, sun, james gosling]
    ListIterator<String> ltr = ll.listIterator();
    while (ltr.hasNext()) {
      String s = ltr.next();

      if (s.equals("james gosling")) {
        ltr.remove(); // [java, sun]
      } else if(s.equals("sun")) {
        ltr.set("oracle"); // [java. oracle]
      } else if(s.equals("java")) {
        ltr.add("awesome java"); // [java, awesome java, oracle]
      }
    }

    System.out.println(ll);
  }
}
