package com.durgasoft.keyinterfaces.collectionInterface.setinterface.sortedSetInterface;

/**
 * Created by ssselim on 10/1/16.
 */
public class CompareToDemo {
  public static void main(String[] args) {
    System.out.println("A".compareTo("Z")); // A comes before Z: -1
    System.out.println("Z".compareTo("K")); // Z comes after  K: +1
    System.out.println("A".compareTo("A")); // A equals to    A:  0
    System.out.println("A".compareTo(null)); // RE: NPE
  }
}
