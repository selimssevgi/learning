package com.durgasoft.multithreading.enhancement.threadlocal;

/**
 * Created by ssselim on 9/30/16.
 */
public class ThreadLocalDemo1A {
  public static void main(String[] args) {
    ThreadLocal tl = new ThreadLocal(){
      public Object initialValue() {
        return "abc";
      }
    };
    System.out.println(tl.get()); // abc
    tl.set("selim");
    System.out.println(tl.get()); // selim
    tl.remove();
    System.out.println(tl.get()); // abc
  }
}
