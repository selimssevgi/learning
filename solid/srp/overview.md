# SRP: Single Responsibility Principle

- There should never be more than one reason for a class to change.

- Requirements changes typically map to responsibilities

- More responsibilities == more likelihood of change


```java
// two methods with two different responsibilities
public class Rectangle {
  // fields
  public double area() {}
  public void render() {}
}
```

- Multiple small interfaces (follow ISP) can help to achieve SRP

## Advantages

- Following SRP leads to lower coupling and higher cohesion

- Many small classes with distinct responsibilities result in a more flexible design

- You will end up having less if, swithc and branching logic
