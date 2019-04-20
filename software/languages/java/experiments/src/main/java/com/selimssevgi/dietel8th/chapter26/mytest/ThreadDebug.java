package com.selimssevgi.dietel8th.chapter26.mytest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ssselim on 9/26/16.
 */
public class ThreadDebug {

  private final static int UPPER_LIMIT = 500;

  public static void main(String[] args) throws InterruptedException {

    Thread t1 = new Thread(() -> {
      for (int i = 0; i < UPPER_LIMIT; i++) {
        System.out.println("Hello");
      }
    });

    Thread t2 = new Thread(() -> {
      for (int i = 0; i < UPPER_LIMIT; i++) {
        System.out.println("Hi");
      }
    });

    ExecutorService es = Executors.newCachedThreadPool();
    es.execute(t1);
    es.execute(t2);
    es.awaitTermination(5, TimeUnit.MINUTES);

  }
}
