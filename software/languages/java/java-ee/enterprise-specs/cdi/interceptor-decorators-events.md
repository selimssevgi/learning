# interceptor, decorators, events

- interpose on method invocation
- separates concerns from our business code
- technical concerns (interceptors)
- business concerns (decorators)

## interceptors

- cross-cutting technical concerns
  - trxs
  - security
  - logging

- business method interceptors (@AroundInvoke)

- life cycle interceptors (@PostConstruct, @PreDestroy)

```java
@InterceptingBinding
@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface Loggable {}

@Loggable
@Interceptor
public class LoggingInterceptor {

  @AroundInvoke
  private Object intercept(InvocationContext ic) throws Exception {
    //stuff
    return ic.proceed();
    
  }
}
```

* by default all interceptors are disabled, we need to enable them by listing in beans.xml


#### interceptor ordering

- the order of the listing in interceptors tag in beans.xml

- @Priority
  - takes an integer of any value
  - smaller priority called first

- java ee 7 defines platform-level priorities
  - PLATFORM_BEFORE = 0
  - LIBRARY_BEFORE = 1000
  - APPLICATION = 2000
  - LIBRARY_AFTER = 3000
  - PLATFORM_AFTER = 4000

- @Priority(PLATFORM_BEFORE + 10)

## decorators

- cross-cutting business concerns

- GoF design pattern

- wrap a class around another one
  - @Decorator
  - @Delegate

- add additional business logic

- interceptors and decorators are complementary

- interceptors before decorators
