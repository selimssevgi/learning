package com.selimssevgi.effectivejava2nd.generics.item28;

/**
 * Created by ssselim on 9/22/16.
 */

import java.util.Arrays;
import java.util.List;

/**
 * Unlike arrays, generic types are invariant
 * That is List<String> is not a subtype of List<Object>
 * Good for compile-time type safety, but inflexible
 *
 * Wildcard types provide additional API flexibility
 * List<String> is a subtype of List<? extends Object>
 * List<Object> is a subtype of List<? super String>
 */
public class WildCard {
  public static void main(String[] args) {
    String[] strArray = {"effective", "java"};

    List<String> list = Arrays.asList(strArray);
    // printList(list); // error cannot pass as List<Object>
    printArray(strArray); // can pass a object[]

  }

  static void printList(List<Object> list) {

  }

  static void printArray(Object[] arr) {
    // passing string array and trying to put integer
    // !! java.lang.ArrayStoreException: java.lang.Integer
    arr[0] = 5;
  }
}
