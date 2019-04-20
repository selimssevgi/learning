package com.selimssevgi.dietel8th.chapter26.threadgroup;

/**
 * Created by ssselim on 9/30/16.
 */
public class MyThreadGruop {
  public static void main(String[] args) {
    System.out.println("theadgroup of main :" + Thread.currentThread().getThreadGroup().getName()); // main
    System.out.println(Thread.currentThread().getThreadGroup().getParent().getName()); // system
    ThreadGroup g1 = new ThreadGroup("First Group");
    System.out.println(g1.getParent().getName()); // main
    ThreadGroup g2 = new ThreadGroup(g1, "Second Group");
    System.out.println(g2.getParent().getName()); // First Group


    ThreadGroup systemGroup = Thread.currentThread().getThreadGroup().getParent();
    Thread[] threads = new Thread[systemGroup.activeCount()];
    systemGroup.enumerate(threads);
    for (Thread t : threads) {
      System.out.println(t.getName() + "isDaemon?: " + t.isDaemon());
    }
  }
}
