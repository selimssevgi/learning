# JUnit best practices

- test anything that could possibly fail

- let the test improve the code

- always specify a reason for skipping a test - @Ignore("reasonable reason")

- write failing tests first

### reduce dependencies

- create simple constructors

- require objects, don't search for objects, and ask only objects that your application requires

```java
class Car {
  private Driver driver;

  Car(Context context) {
    this.driver = context.getDriver();
  }
}

class Car {
  private Driver driver;

  Car(Driver driver) {
    this.driver = driver;
  }
}
```

- avoid hidden dependenciees and global state

- favor generic methods
  - static methods are compile-time binded, no polymorphism for testing

- favor composition over inheritance
  - cannot change inheritance while testing
  - can mock composed collabrator

- favor polymorphism over conditionals (long if/switch)
  - every new case, requires code change
  - polymorphism is a natural OO way to avoid long conditionals
