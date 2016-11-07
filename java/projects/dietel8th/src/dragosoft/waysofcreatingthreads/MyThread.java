package dragosoft.waysofcreatingthreads;

/**
 * One way of defining a thread is extending Thread class
 * and overriding run method.
 * Created by ssselim on 9/26/16.
 */
public class MyThread extends Thread{

  @Override
  public void run() {
    // defining the job that this thread will execute
    for (int i = 0; i < 10; i++) {
      System.out.println("Child Thread");
      Thread.yield();
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void run(int i) {
    System.out.println("ARgument value: " + i);
  }
}
