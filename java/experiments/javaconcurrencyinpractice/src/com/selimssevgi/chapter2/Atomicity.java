package com.selimssevgi.chapter2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ssselim on 9/29/16.
 */
public class Atomicity {

  public static void main(String[] args) {
    // check java.util.concurrent.atomic
    AtomicLong count = new AtomicLong(0);
    count.incrementAndGet();
  }
}
