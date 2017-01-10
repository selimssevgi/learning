package com.durgasoft.keyinterfaces;

import java.util.*;

/**
 * Created by ssselim on 10/1/16.
 */
public class Interfaces {
  Collection c; // interface
  List l = Collections.EMPTY_LIST; // utility class for collection objects

  List myList = new ArrayList<>(); // not synchronized, not thread safe
  List synchronizedList = Collections.synchronizedList(myList);
  List ll = new LinkedList<>(); // best use case of insertion or deletion in middle, worst for random access.
  List myVector = new Vector<>(); // synchronized, thread safe
  Stack stack = new Stack();

  Set s;



}
