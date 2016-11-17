package com.selimssevgi.dietel8th.chapter26.producerconsumer;

/**
 * specifies the methods called by Producer and Consumer
 * Created by ssselim on 9/25/16.
 */
public interface Buffer {

  // place int value into Buffer
  void  set(int value) throws InterruptedException;

  // return int value from Buffer
  int get() throws InterruptedException;
}
