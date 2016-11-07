package chapter26.blocksynch;

/**
 * Created by ssselim on 9/28/16.
 */
public class Display {

  // block synch over method synch
  public void wish(String name) {
    ;;;;;; // code that doesnt require synch
    int x = 10;
//    synchronized (x) // ERROR: cannot get lock of primitive types
//    synchronized (this) { // object level lock
    synchronized (Display.class) { // class level lock
      for (int i = 0; i < 10; i++) {
        System.out.print("Good morning: ");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(name);
      }
    }
    ;;;;;; // code that doesnt require synch
  }
}
