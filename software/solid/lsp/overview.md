# Liskov Substitution Principle (LSP)

```shell
public class Rectangle {
  public Rectangle(int x, int y, int width, int height) {}
  public void setWidth(int width) {}
  public void setHeight(int height) {}
  public int getArea() {}
}
```

- Can we create a subclass named Square?

```shell
public class Square {
  //...
  public Square(int x, int y, int width) {}
  //...
}

Rectangle r = new Square();
r.setWidth(3);       // they could modify the same variable
r.setHeight(4);      // they could expect 12 instead of 16 in this setup
```

- this ia classes example of LSP violation.

- objects of subclasses should be substitutable for objects of their
  superclasses throughout your code. If they arent, we could have silent errors in our code.


- some rules of thumb:

1. whenever possible, avoid overriding concrete methods

2. if you do, see if you can call the method you are overriding in the overriding method.

#### normalized hierarchy

- in a normalized hierarchy, no class has more than one implementation of a method

- none of the classes has a method that overrides a concrete method in inherited from a superclass

- When you ask: "How does this class do X?" you can answer by looking at class X

- Either the method is there or it is abstract and implemented in one of the subclasses

- in normalized hierarchy you dont have to worry about subclasses overriding
  behavior they inherited from their superclasses
