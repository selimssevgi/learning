# 100% Coverage

- Does not mean anything

- Agnostic about quality of the tests

 - Unaware of functionality coverage

 - Not even check for asserts

```kotlin
class Calculator {
  fun sum(a: Int, b: Int): Int {
    return 4
  }
}

@Test
fun sumOfOneAndThreeIsFour() {
  val result = Calculator().sum(1, 3)

  // does not even have assert
}

@Test
fun sumOfOneAndThreeIsFour() {
  val result = Calculator().sum(1, 3)

  assertEquals(4, result) // not useful tests
}
```
