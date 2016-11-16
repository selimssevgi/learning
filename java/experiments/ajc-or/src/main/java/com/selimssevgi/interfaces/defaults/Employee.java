package com.selimssevgi.interfaces.defaults;

/**
 * Created by ssselim on 11/15/16.
 */
public interface Employee {
  String getFirst();
  String getLast();
  void doWork();

  default String getName() {
    return String.format("%s %s", getFirst(), getLast());
  }
}
