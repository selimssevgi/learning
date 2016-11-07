package com.selimssevgi;

/**
 * An indivual coffee that has been served.
 * Created by ssselim on 10/18/16.
 */
public final class Coffee {

  private final CoffeeType type;
  private final int beans;
  private final int milk;

  public Coffee(CoffeeType type, int beans, int milk) {
    this.type = type;
    this.beans = beans;
    this.milk = milk;
  }

  public CoffeeType getType() {
    return type;
  }

  public int getBeans() {
    return beans;
  }

  public int getMilk() {
    return milk;
  }

  @Override
  public String toString() {
    return "Coffee{" +
            "type-" + type +
            "beans-" + beans +
            "milk-" + milk +
            "}";
  }
}
