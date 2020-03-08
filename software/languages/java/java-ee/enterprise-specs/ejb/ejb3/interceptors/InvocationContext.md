# InvocationContext

- InvocationContext#proceed() calls the next inceptor in the chain or proceed
  with the underlying object

- InvocationContext#getContextData() is the fact that contexts are shared across
  the interceptor chain for a given method

```java
ctx.getContextData().put("key", "value");
```
