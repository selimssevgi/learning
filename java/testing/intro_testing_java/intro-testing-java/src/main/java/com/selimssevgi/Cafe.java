package com.selimssevgi;

import com.google.common.base.Preconditions;

/**
 * A coffee shop that can brew coffee and
 * maintains an internal stock of beans and milk
 * Created by ssselim on 10/18/16.
 */
public final class Cafe {

  private int beansInStock = 0;
  private int milkInStock  = 0;

  public Coffee brew(CoffeeType coffeeType) {
    return brew(coffeeType, 1);
  }

  public Coffee brew(CoffeeType coffeeType, int quantity) {
    Preconditions.checkArgument( quantity > 0, "negative value");

    int requiredBeans = coffeeType.getRequiredBeans() * quantity;
    int requiredMilk  = coffeeType.getRequiredMilk() * quantity;
    if (requiredBeans > beansInStock || requiredMilk > milkInStock) {
      throw new IllegalStateException("Insufficient beans or milk");
    }

    beansInStock -= requiredBeans;
    milkInStock  -= requiredMilk;
    return new Coffee(coffeeType, requiredBeans, requiredMilk);
  }

  public void restockBeans(int weightInGrams) {
    Preconditions.checkArgument(weightInGrams > 0, "negative value");
    beansInStock += weightInGrams;
  }

  public void restockMilk(int weightInGrams) {
    Preconditions.checkArgument(weightInGrams > 0, "negative value");
    milkInStock += weightInGrams;
  }

  public int getBeansInStock() {
    return beansInStock;
  }

  public int getMilkInStock() {
    return milkInStock;
  }
}
