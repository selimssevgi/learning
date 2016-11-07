package com.durgasoft.keyinterfaces.mapInterface;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by ssselim on 10/2/16.
 */
public class WeakHashMapDemo {
  public static void main(String[] args) throws InterruptedException {
    //HashMap<Temp, String> m = new HashMap<>();
    WeakHashMap<Temp, String> m = new WeakHashMap<>();
    Temp t = new Temp();
    m.put(t, "Selim");
    System.out.println(m);
    t = null; // in case of HashMap, gc cannot destroy it, finalize wont be called
              // in case of WeakHashMap, gc will destroy it, finalize will be called
    System.gc();
    Thread.sleep(5000);
    System.out.println(m);

  }
}

class Temp {
  @Override
  public String toString() {
    return "temp";
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("Finalize method called");
  }
}
