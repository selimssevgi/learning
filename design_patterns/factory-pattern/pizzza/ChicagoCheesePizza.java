public class ChicagoCheesePizza extends Pizza {

  public ChicagoCheesePizza() {
    name = "Chicago Style Deep Dish Cheese Pizza";
    dough = "Extra Thick Crust Dough Crust Dough";
    sauce = "Plum Tomato Sauce";

    toppings.add("Shredded Mozzarella Cheese");
  }

  @Override
  void cut() {
    System.out.println("Cutting the pizza into square slices");
  }
}
