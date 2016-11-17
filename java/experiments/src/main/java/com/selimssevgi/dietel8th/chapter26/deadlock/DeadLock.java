package com.selimssevgi.dietel8th.chapter26.deadlock;

/**
 * Created by ssselim on 9/29/16.
 */
public class DeadLock extends Thread {
  ClassA a = new ClassA();
  ClassB b = new ClassB();

  public void m1() {
    this.start();
    // after this point there are two threads
    // main thread will execute the following line
    a.d1(b);
  }

  public void run() {
    // child/this thread is executing the following
    b.d2(a);
  }

  public static void main(String[] args) {
    Thread mt = Thread.currentThread();
    System.out.println(mt.getName() + " : " + mt.isDaemon());
    //mt.setDaemon(true); // IllegalThreadStateException
    DeadLock dl = new DeadLock();
    dl.m1();
  }
}
