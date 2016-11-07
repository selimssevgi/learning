package chapter26.deadlock;

/**
 * Created by ssselim on 9/29/16.
 */
public class ClassA {

  public synchronized void d1(ClassB b) {
    System.out.println("Thread1 start executing d1 method");
    try {
      Thread.sleep(2000); // give change to other thread to start
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Thread1 trying to call ClassB lastmethod");
    b.lastMethod();
  }

  public synchronized void lastMethod() {
    System.out.println("inside ClassA lastmethod");

  }
}
