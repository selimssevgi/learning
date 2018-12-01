package com.selimssevgi.durgasoft.multithreading.waysofcreatingthreads;

/**
 * Created by ssselim on 9/26/16.
 */
public class MyRunnableDemo {
  public static void main(String[] args) {
    Thread t = new Thread(new MyRunnable());
    t.start();

    for (int i = 0; i < 10; i++) {
      System.out.println("Main Thread");
    }
  }
}
