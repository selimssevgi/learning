package com.durgasoft.keyinterfaces.collectionInterface.setinterface.sortedSetInterface;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by ssselim on 10/2/16.
 */
public class TreeSetDemo6 {
  public static void main(String[] args) {
    // using d.n.s.o provided by Employee class
    TreeSet<Employee> t = new TreeSet<>();
    t.add(new Employee("java", 1));
    t.add(new Employee("oracle", 2));
    t.add(new Employee("android", 3));
    System.out.println(t); // [java--1, oracle--2, android--3]


    // i want to sorted by name, customized comparator
    TreeSet<Employee> t2 = new TreeSet<>(new SortByName());
    t2.add(new Employee("java", 1));
    t2.add(new Employee("oracle", 2));
    t2.add(new Employee("android", 3));
    System.out.println(t2); // [android--3, java--1, oracle--2]
  }

  private static class SortByName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
      Employee e1 = (Employee) o1;
      Employee e2 = (Employee) o2;
      String n1 = e1.name;
      String n2 = e2.name;

      return n1.compareTo(n2);
    }
  }
}
