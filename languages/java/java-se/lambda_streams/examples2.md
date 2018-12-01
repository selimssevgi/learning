# Stream Examples

```java
String[] upcase(String[] input) {
  return Arrays.stream(input)
               .map(String::toUpperCase)
               .toArray(String[]::new);
}
```
