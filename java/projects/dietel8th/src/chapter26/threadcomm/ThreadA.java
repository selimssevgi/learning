package chapter26.threadcomm;

/**
 * Created by ssselim on 9/29/16.
 */
public class ThreadA {
  public static void main(String[] args) throws InterruptedException {
    ThreadB b = new ThreadB();
    b.start(); // calculating total in a thread

    // What is b thread start to get cpu before main thread?
    Thread.sleep(3001); // will cause main thread waiting forever
    // final version
    synchronized (b) {
      System.out.println("main thread trying to call wait method on b");
      try {
        b.wait(10000); // to prevent problems of waiting forever
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    //try {
      // using sleep for method for notification is not a good practise
      // Thread.sleep(10000);
      // it will wait until b thread done all of its work, but i may need just some part of it
      // b.join();
      // cannot call wait method here, not in synchronized area
      // b.wait();
    // } catch (InterruptedException e) {
     // e.printStackTrace();
    // }
    System.out.println("main thread got notification");
    System.out.println(b.total); // try to access total value immediately
  }
}
