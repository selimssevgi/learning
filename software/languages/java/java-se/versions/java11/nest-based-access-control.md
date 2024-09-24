# Nest-based Access-control

- A JVM level feature

- Developer perspective, it looks like a single class

```java
public class ClassA {

  private ReturnType methodName() {}

  static class InnerClass {
    // can access private methods of ClassA
  }
}
```

- In JVM perspective, there are two class file

1. ClassA
2. InnerClass

* Normally a class should not be able to call a private method of another class?

- javac inserts a so-called bridge method that is accessible from other classes.
  Internall, it delegates to the private method

- If someone would use reflection to access the real private method from inner
  class, it would fail at runtime

## Java 11 Solution

- Outer class and inner class are going to be "nestmates"

- Inner class can now access internal parts of outer class "directly" in the nest

- javac does not have to generate any bridge methods

- javac only has to reflect the nesting structure in the new class file
  attributes that are available for this.

- It will also enable future improvement and new features
