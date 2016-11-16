package com.selimssevgi.interfaces.defaults;

/**
 * Created by ssselim on 11/15/16.
 */
public class CompanyEmployee implements Company, Employee{
  private String first;
  private String last;

  @Override
  public String getFirst() {
    return first;
  }

  @Override
  public String getLast() {
    return last;
  }

  @Override
  public void doWork() {
    System.out.println("Working...");
  }

  @Override
  public String getName() {
    return String.format("%s working for %s",
            Employee.super.getName(), Company.super.getName());
  }
}
