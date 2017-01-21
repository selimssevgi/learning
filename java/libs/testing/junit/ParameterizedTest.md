# Parameterized Test


```java
@RunWith(Parameterized.class)
public class ParameterizedTest {
  String email;
  boolean expected;

  public ParameterizedTest(String email, boolean expected) {
    this.email    = email;
    this.expected = expected;
  }

  @Parameters
  public static List<Object[]> getParams() {
    return Arrays.asList(
      new Object[] {
        {true, "selimssevgi@gmail.com"},
        {false, "12@com"}
      }
    );
  }

  @Test
  public void validateEmails() {
    // test  
  }
}
```
