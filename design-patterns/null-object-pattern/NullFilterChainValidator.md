# FilterChainProxy from Spring Security

```java
public interface FilterChainValidator {
  void validate(FilterChainProxy filterChainProxy);
}

private static class NullFilterChainValidator implements FilterChainValidator {
  @Override
  public void validate(FilterChainProxy filterChainProxy) {
  }
}
```
