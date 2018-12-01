package com.selimssevgi.durgasoft.multithreading.waysofcreatingthreads;

/**
 * Created by ssselim on 9/26/16.
 */
public class MyRunnable implements Runnable{
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Child Thread");
    }
  }
}
