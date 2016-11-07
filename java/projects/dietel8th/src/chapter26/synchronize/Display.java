package chapter26.synchronize;

/**
 * Created by ssselim on 9/28/16.
 */
public class Display {

  // sync keywords, lets just one thread to execute this method
  public synchronized void wish(String name) {
    System.out.print("Good morning: ");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(name);
  }

}
