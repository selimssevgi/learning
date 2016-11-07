package chapter26.deadlock;

/**
 * Created by ssselim on 9/29/16.
 */
public class ClassB {

  public synchronized void d2(ClassA a) {
    System.out.println("Thread2 start execution of d2 method");
    try {
      Thread.sleep(5000); // give other thread to start to in case this one will start first
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Thread2 trying to call ClassA lastmethod");
    a.lastMethod();
  }

  public synchronized void lastMethod() {
    System.out.println("Inside ClassB last method");
  }
}
