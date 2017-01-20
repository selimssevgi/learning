# Testing Exceptions


```java
public class ClassTest {

  @Test(expected = ArithmeticException.class)
  public void throwsArithmeticException() {
      int x = 5 / 0;
  }

}
```
