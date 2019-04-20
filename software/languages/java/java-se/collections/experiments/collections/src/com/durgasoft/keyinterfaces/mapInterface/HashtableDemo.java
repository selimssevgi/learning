package com.durgasoft.keyinterfaces.mapInterface;

import java.util.Hashtable;

/**
 * Created by ssselim on 10/3/16.
 */
public class HashtableDemo {
  public static void main(String[] args) {
    Hashtable<Temp, String> h = new Hashtable<>();
    // we have 11 buckets in hastable by default
    h.put(new Temp(5), "A"); // goes 5th bucket in the hashtable
    h.put(new Temp(2), "B"); // goes 2th bucket in the hashtable
    h.put(new Temp(6), "C"); // goes 6th bucket in the hashtable
    h.put(new Temp(15), "D"); // there is no 15th bucket, 15 % 11 = 4th bucket
    h.put(new Temp(23), "E"); // there is no 23rd bucket, 23 % 11 = 2nd bucket
    h.put(new Temp(16), "F"); // there is no 16th bucket, 16 % 11 = 5th bucket
    //h.put(null, "G"); RE: NPE
    //h.put(new Temp(71), null); // RE:NPE
    System.out.println(h); // {6=C, 16=F, 5=A, 15=D, 2=B, 23=E}
  }

  private static class Temp {
    int i;

    Temp(int i) {
      this.i = i;
    }

    @Override
    public int hashCode() {
      return i;
    }

    @Override
    public String toString() {
      return i + "";
    }
  }
}
