package com.selimssevgi.dietel8th.chapter26.synchronize;

/**
 * Created by ssselim on 9/28/16.
 */
public class WishingTask implements Runnable {

  private final Display d;
  private final String name;

  public WishingTask(Display d, String name) {
    this.name = name;
    this.d = d;
  }

  @Override
  public void run() {
    d.wish(name);
  }
}
