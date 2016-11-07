package com.durgasoft.multithreading.enhancement.locks.withoutsynchronized;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ssselim on 9/30/16.
 */

class MyThread2 extends Thread {
  // lock is unique to the class, so is static
  static ReentrantLock l = new ReentrantLock();

  MyThread2(String name) {
    super(name);
  }

  public void run() {
    //if (l.tryLock()) { // immediately returns true or false
    try {
      if (l.tryLock(5000, TimeUnit.MILLISECONDS)) {
        System.out.println(Thread.currentThread().getName()
                + ": got the lock and performing safe operations");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        l.unlock();
      } else {
        System.out.println(Thread.currentThread().getName()
                + ": unable to get lock and hence performing alternative operations");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

public class ReentrantLock3 {

  public static void main(String[] args) {
    MyThread2 t1 = new MyThread2("First Thread");
    MyThread2 t2 = new MyThread2("Second Thread");
    t1.start();
    t2.start();
  }
}
