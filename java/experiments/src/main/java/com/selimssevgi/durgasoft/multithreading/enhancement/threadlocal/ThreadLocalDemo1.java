package com.selimssevgi.durgasoft.multithreading.enhancement.threadlocal;

/**
 * Created by ssselim on 9/30/16.
 */
public class ThreadLocalDemo1 {
  public static void main(String[] args) {
    ThreadLocal tl = new ThreadLocal();
    System.out.println(tl.get()); // null
    tl.set("selim");
    System.out.println(tl.get()); // selim
    tl.remove();
    System.out.println(tl.get()); // null
  }
}
