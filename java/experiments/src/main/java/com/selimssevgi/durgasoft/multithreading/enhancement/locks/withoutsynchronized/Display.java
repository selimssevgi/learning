package com.selimssevgi.durgasoft.multithreading.enhancement.locks.withoutsynchronized;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ssselim on 9/30/16.
 */
public class Display {
  ReentrantLock l = new ReentrantLock();
  public void wish(String name) {
    l.lock();
    for (int i = 0; i < 10; i++) {
      System.out.println("Good morning:");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(name);
    }
    l.unlock();

  }
}
