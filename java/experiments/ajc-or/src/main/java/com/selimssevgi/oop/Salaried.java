package com.selimssevgi.oop;

/**
 * Created by ssselim on 11/15/16.
 */
public class Salaried extends Employee{
  public static final double DEFAULT_SALARY = 12000;

  private double salary = DEFAULT_SALARY;

  public Salaried() {}

  public Salaried(String name) {
    this(name, DEFAULT_SALARY);
  }

  public Salaried(String name, double salary) {
    super(name);
    this.salary = salary;
  }

  public double getSalary() { return salary; }
  public void setSalary(double salary) { this.salary = salary; }

  @Override
  public double getPay() {
    return salary / 24;
  }
}
