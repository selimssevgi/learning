public abstract class Duck {
  QuackBehavior quackBehavior;
  FlyBehavior   flyBehavior;

  public void performQuack() { quackBehavior.quack(); }
  public void performFly()   { flyBehavior.fly(); }

  public abstract void display();

  public void swim() { System.out.println("Swimming..."); }

  // optional setters, if members are not passed into constructor
  public void setFlyBehavior(FlyBehavior fb)     { flyBehavior = fb; }
  public void setQuackBehavior(QuackBehavior qb) { quackBehavior = qb; }
}
