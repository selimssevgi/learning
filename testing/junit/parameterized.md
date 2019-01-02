# Parameterized

```java
@RunWith(Parameterized.class)
public class ParameterizedTest {

  private double expected;
  private double valueOne;
  private double valueTwo;

  public ParameterizedTest(double expected, double valueOne, double valueTwo) {
    this.expected = expected;
    this.valueOne = valueOne;
    this.valueTwo = valueTwo;
  }

  // method signature should be exactly like this
  @Parameters
  public static Collection<Integer[]> getTestParameters() {
    return Arrays.asList(
        new Integer[] {1, 2, 3},
        new Integer[] {4, 5, 9}
    );
  }

  @Test
  public void sum() {
    Calcuator calcuator = new Calcuator();
    double result = calcuator.add(valueOne, valueTwo);
    assertEquals(expected, result, 0);
  }

  private class Calcuator {
    public double add(double d1, double d2) {
      return d1 + d2;
    }
  }
}

```
