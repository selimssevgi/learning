public class ChicagoPizzaStore extends PizzaStore {

  @Override
  Pizza createPizza(String type) {
    Pizza pizza = null;
    switch(type) {
      case "cheese":
        pizza = new ChicagoCheesePizza();
        break;
      // case "pepperoni":
      //   pizza = new ChicagoStylePepperoniPizza();
      //   break;
      // case "clam":
      //   pizza = new ChicagoStyleClamPizza();
      //   break;
      // case "veggie":
      //   pizza = new ChicagoStyleVeggiePizza();
      //   break;
    }
    return pizza;
  }
}
