# AssertThat

- Is more readable and more useful than assertEquals.
- public static T assertThat(T actual, Matcher matcher)

## Matcher
- A matcher enables a partial or an exact match for an expectation, whereas 
  assertEqual uses an exact match.
- Matcher provides utility methods such as: is, either, or, not, and, hasItem.
- Matcher methods use the Builder Pattern so that we can combine one or more
  matchers to build a composite matcher chain.


## Examples

- org.hamcrest.CoreMatchers
- JUnitMatchers are deprecated.
- allOf, anyOf, both, either, describedAs, everyItem, is, isA, anything,
  hasItem, hasItems, equalTo, any, instanceOf, not, notValue, notNullValue,
  sameInstance, theInstance, startsWith, endsWith, containsString

```java
assertThat(calculatedTax, is(not(thirdyPercent)));
assertThat(students, hasItem("John"));

assertThat(age, is(30));
assertThat(age, is(not(30)));
assertThat(age, equalTo(30));
assertThat(age, not(equalTo(30)));
```
