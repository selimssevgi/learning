package dragosoft.waysofcreatingthreads;

/**
 * Created by ssselim on 9/26/16.
 */
public class MyThreadDemo {
  public static void main(String[] args) {

    System.out.println("main Thread priority : " + Thread.currentThread().getPriority());
    System.out.println("Current Thread:" + Thread.currentThread().getName());

    // at this point there is just main thread
    MyThread t = new MyThread();
//    t.setPriority(10);
    t.start();
//    t.run();
    // after above line there are two different flow of execution
    // two threads

    t.setName("Selim");
    System.out.println("child Thread priority : " + t.getPriority());
    System.out.println("Child Thread name: " + t.getName());


    for (int i = 0; i < 10; i++) {
      System.out.println("main thread");
    }
  }
}
