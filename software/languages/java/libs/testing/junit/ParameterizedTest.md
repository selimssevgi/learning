# Parameterized Test

- Used for multiple iterations over single input to stress the object in test.
- Primary reason is to reduce the amount of test code.
- If the dataset return an empty collection, the test doesnt fail. Nothing happens.
- IllegalArgumentException for {1,2,3} but contructor takes two parameters.

* There are two ways: with/without constructor

### With a constructor
```java
@RunWith(Parameterized.class)
public class FactorialTest {

  private int number;
  private long expectedResult;

  // Parameterized runner needs a constructor to pass the collection of data
  public FactorialTest(int number, long expectedResult) {
    this.number = number;
    this.expectedResult = expectedResult;
  }


  // @Parameters(name = "{index} : factorial({0})={1}") : more readable
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {5, 120}
    });
  }

  @Test
  public void test() {
    Factorial fact = new Factorial();
    assertThat(fact.factorial(number), equalTo(expectedResult));
  }

}
```

### Without a constructor

- Fields must be public.

```java
@RunWith(Parameterized.class)
public class ParameterizedParamFactorialTest {
  // Fields must be public, otherwise security exception
  @Parameter(value = 0)
  public int number;
  @Parameter(value = 1)
  public long expectedResult;

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
            {0, 1},
            {1, 1},
            {3, 6},
            {5, 120},
    });
  }

  @Test
  public void test() {
    Factorial factorial = new Factorial();
    assertThat(factorial.factorial(number), CoreMatchers.equalTo(expectedResult));
  }
}
```
