public class DuckTestDrive {
  public static void main(String[] args) {
    MallardDuck duck = new MallardDuck();
    WildTurkey turkey = new WildTurkey();

    Duck turkeyAdapter = new TurkeyAdapter(turkey);

    System.out.println("Turkey says...");
    turkey.gobble();
    turkey.fly();

    System.out.println("Duck says...");
    test(duck);

    System.out.println("TurkeyAdapter says...");
    test(turkeyAdapter);
  }

  static void test(Duck duck) {
    duck.quack();
    duck.fly();
  }
}
