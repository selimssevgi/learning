package com.durgasoft.multithreading.enhancement.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ssselim on 9/30/16.
 */
public class ExecutorDemo {

  public static void main(String[] args) {
    PrintJob[] jobs = {
            new PrintJob("Selim"),
            new PrintJob("Sirri"),
            new PrintJob("Sevgi"),
            new PrintJob("Durga"),
            new PrintJob("Sir"),
    };

    ExecutorService service = Executors.newFixedThreadPool(2);

    for (PrintJob job : jobs) {
      service.submit(job);
    }
    service.shutdown();
  }
}
