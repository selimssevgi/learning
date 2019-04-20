# junit timeout test

- you can specify time barrier in terms of milliseconds

```java
@Test(timeout = 130)
public void shouldHandleWithTimeout(){}
```

- the timing would be dependent on so many variables: os, tools, new added functionality etc

- sometimes we may want to skip such tests, use @Ignore
