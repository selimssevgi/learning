package com.selimssevgi.durgasoft.multithreading.enhancement.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ssselim on 9/30/16.
 */
public class ReentrantLock2 {
  public static void main(String[] args) {
    ReentrantLock l = new ReentrantLock();

    l.lock();
    l.lock();
    System.out.println("Is locked: " + l.isLocked()); // true
    System.out.println("Is held by current thread: " + l.isHeldByCurrentThread()); // true
    System.out.println("getQueueLength : " + l.getQueueLength()); // 0
    l.unlock();
    System.out.println("hold count: " + l.getHoldCount()); // 1
    System.out.println("Is locked: " + l.isLocked()); // true
    l.unlock();
    System.out.println("Is locked: " + l.isLocked()); // false
    System.out.println("Is fair: " + l.isFair()); // false
  }
}
