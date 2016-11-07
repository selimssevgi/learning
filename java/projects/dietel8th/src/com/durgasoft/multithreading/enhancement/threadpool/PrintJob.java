package com.durgasoft.multithreading.enhancement.threadpool;

/**
 * Created by ssselim on 9/30/16.
 */
public class PrintJob implements Runnable{

  String name;

  public PrintJob(String name) {
    this.name = name;
  }

  @Override
  public void run() {

    System.out.println(name + "...job started by thread:"
            + Thread.currentThread().getName());
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(name + "...job completed by thread:"
            + Thread.currentThread().getName());
  }
}
