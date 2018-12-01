# 'this' keyword in lambdas

- The usage of 'this' can show that lambda are not anonymous classes!

- 'this' refers to this as it is outside of lambda scope.

```java
public class Lambdas {
  public void method() {
    Runnable runnable = () -> {
      System.out.println("Can print this");
      System.out.println(this);
      System.out.println("this refers to outside object");
      return;
    };
  }

  public static void staticMethod() {
    Runnable runnable = () -> {
      System.out.println("Can not print this");
      System.out.println(this); // cannot reference from static context
      System.out.println("this refers to outside object");
      return;
    };
  }
}
```
