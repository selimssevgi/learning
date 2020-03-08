# interceptor binding

```java
@InterceptorBinding
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface Audited {}
```

- we should tell if our interceptor has any bindings

```java
@Audited @Interceptor
public class AuditInterceptor {}
```

- mark a class

```java
@Stateless
@Audited
public class BidService {}
```

- or mark a method

```java
@Stateless
public class BidService {
  @Audited
    public void addBid(Bid bid) {
      bidDao.addBid(bid);
    }
}
```
