package com.durgasoft.multithreading.enhancement.threadpool;

import java.util.concurrent.Callable;

/**
 * Created by ssselim on 9/30/16.
 */
public class MyCallable implements Callable {
  int num;

  public MyCallable(int num) {
    this.num = num;
  }

  @Override
  public Object call() throws Exception {
    System.out.println(Thread.currentThread().getName()
            + "... is responsible find sum of first " + num + " numbers");

    int sum = 0;
    for (int i = 1; i <= num; i++) {
      sum = sum + i;
    }
    return sum;
  }
}
