package com.selimssevgi.dietel8th.chapter26.threadcomm;

/**
 * Created by ssselim on 9/29/16.
 */
public class ThreadB extends Thread {
  int total = 0;

  public void run() {

    synchronized (this) {
      System.out.println("child thread starting calculation");
      for (int i = 0; i < 100; i++) {
        total += i;
      }
      System.out.println("Child thread trying to give notification");
      this.notify();
    }

    // cannot call when not in synch area
    // this.notify();
    // join will have to wait also for statement here
  }
}
