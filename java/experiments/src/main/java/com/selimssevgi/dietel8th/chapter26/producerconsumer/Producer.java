package com.selimssevgi.dietel8th.chapter26.producerconsumer;

import java.util.Random;

/**
 * Created by ssselim on 9/25/16.
 */
public class Producer implements Runnable {
  private final static Random rand = new Random();
  private final Buffer sharedLocation; // reference to shared object

  public Producer(Buffer shared) {
    sharedLocation = shared;
  }

  @Override
  public void run() {

    int sum = 0;

    for (int count=1; count <=10; count++) {
      try {
        Thread.sleep(rand.nextInt(3000));
        sharedLocation.set(count);
        sum += count;
        System.out.printf("\t%2dn", sum);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("Producer done producing\nTerminating Producer");
  }
}
