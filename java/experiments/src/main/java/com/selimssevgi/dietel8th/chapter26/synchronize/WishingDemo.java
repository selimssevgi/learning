package com.selimssevgi.dietel8th.chapter26.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ssselim on 9/28/16.
 */
public class WishingDemo {
  public static void main(String[] args) {

    Display d = new Display();
    Display d2 = new Display();

    // if there is only one thread, there wont be problem
    Thread t1 = new Thread(new WishingTask(d, "selim"));
    // but if there are more than one, they will be sync problem
    // good morning: good morning etc.
    Thread t2 = new Thread(new WishingTask(d, "ahmet"));

    // even though method is synch, different objects require
    // different locks, therefore output will be irregular
    Thread t3 = new Thread(new WishingTask(d2, "mehmet"));

    ExecutorService es = Executors.newCachedThreadPool();
    es.execute(t1);
    es.execute(t2);
    es.execute(t3);
    es.shutdown();
  }
}
