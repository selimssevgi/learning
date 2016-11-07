package com.durgasoft.multithreading.enhancement.locks.withoutsynchronized;

/**
 * Created by ssselim on 9/30/16.
 */
public class SynchronizedDemo {
  public static void main(String[] args) {
    Display d = new Display();
    MyThread t1 = new MyThread(d, "selim");
    MyThread t2 = new MyThread(d, "ahmet");
    t1.start();
    t2.start();
  }
}
