# Hamcrest Quick Intro

- artifactId: java-hamcrest
- A compositional matcher library
- Helps us avoid repetition and improve diagnostics


## Matcher

- A simple and general blob of logic used in assertions.
- A map contains 'this' key.

## Compositional

- Matchers can be combine multiple matchers.
- A number is 5 or 7.


```java
assertThat(numbers, hasItem(5));
assertThat(numbers, hasItems(5, 7));
assertThat(person, hasProperty("name", equalTo("selim")));
assertThat("Selim", equalTo("Selim"));

assertThat("a b c", allOf(
  equalTo("a b c"),
  instanceOf(String.class),
  not(containing("x y z"))));
```

