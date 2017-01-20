# JUnit 

- Tests are code, treat them like it.
- Test classes should end with Test. (StringHelperTest.java)
- Each method in test class should public, void, no-arg.
- Annotate methods with @Test


```java
public class StringHelperTest {

  @Test
  public void test() {
    String expected = "test";
    String actual   = "test";
    assertEquals(expected, actual);
  }
}
```
