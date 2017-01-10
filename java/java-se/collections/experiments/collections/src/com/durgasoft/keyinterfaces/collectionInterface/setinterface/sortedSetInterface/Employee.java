package com.durgasoft.keyinterfaces.collectionInterface.setinterface.sortedSetInterface;

/**
 * Created by ssselim on 10/2/16.
 */
public class Employee implements Comparable{
  String name;
  int eid;

  public Employee(String name, int eid) {
    this.name = name;
    this.eid = eid;
  }

  @Override
  public int compareTo(Object o) {
    int eid1 = this.eid;
    Employee e = (Employee) o;
    int eid2 = e.eid;
    if (eid1 < eid2)
      return -1;
    else if (eid1 > eid2)
      return +1;
    else
      return 0;
  }

  @Override
  public String toString() {
    return name + "--" + eid;
  }
}
