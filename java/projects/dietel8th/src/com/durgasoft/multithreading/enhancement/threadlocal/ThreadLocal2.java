package com.durgasoft.multithreading.enhancement.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ssselim on 9/30/16.
 */
class CustomerThread extends Thread {
  static Integer custId = 0;
  static AtomicInteger atomicId = new AtomicInteger(0);
  private static ThreadLocal tl = new ThreadLocal() {
    protected Integer initialValue() {
      // return ++custId; // gives mixed output! is not atomic!
      return atomicId.getAndIncrement();
    }
  };

  CustomerThread(String name) {
    super(name);
  }

  public void run() {
    System.out.println(Thread.currentThread().getName()
            + "executing with Customer id:" + tl.get());
  }
}
public class ThreadLocal2 {
  public static void main(String[] args) {
    CustomerThread c1 = new CustomerThread("CustomerThread-1");
    CustomerThread c2 = new CustomerThread("CustomerThread-2");
    CustomerThread c3 = new CustomerThread("CustomerThread-3");
    CustomerThread c4 = new CustomerThread("CustomerThread-4");
    c1.start();
    c2.start();
    c3.start();
    c4.start();
  }
}
