package com.durgasoft.multithreading.enhancement.locks.withoutsynchronized;

/**
 * Created by ssselim on 9/30/16.
 */
public class MyThread extends Thread{
  Display d;
  String name;

  MyThread(Display d, String n) {
    this.d = d;
    name = n;
  }

  public void run() {
    d.wish(name);
  }
}
