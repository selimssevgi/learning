package com.selimssevgi.dietel8th.chapter26.blocksynch;

/**
 * Created by ssselim on 9/28/16.
 */
public class BlockSynchDemo {
  public static void main(String[] args) {
    Display d = new Display();
    Display d1 = new Display();

    MyThread t1 = new MyThread(d, "selim");
    MyThread t2 = new MyThread(d1, "ahmet");

    t1.start();
    t2.start();
  }
}
