public class PizzaTestDrive {
  public static void main(String[] args) {
    PizzaStore nyStore = new NYPizzaStore();
    PizzaStore chStore = new ChicagoPizzaStore();

    Pizza p1 = nyStore.orderPizza("cheese");
    System.out.println("Ethan ordered a " + p1.getName() + "\n");
    Pizza p2 = chStore.orderPizza("cheese");
    System.out.println("Joel ordered a " + p2.getName() + "\n");
  }
}
