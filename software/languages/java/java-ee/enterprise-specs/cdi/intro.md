# injecting with CDI

- standard

- manages dependencies

- strongly typed annotations

- xml configuration

- removes construction by hand

- many other features to DI


```java
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {}

@EightDigits
public class IssnGenerator implements NumberGenerator {}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD, PARAMETER})
public @interface EightDigits {}

public class BookService {
  @Inject
  @ThirteenDigits
  private NumberGenerator generator;
}
```

### managed bean

- bean managed by a container

* java se
  - objects
  - jvm is a container
  - class loading
  - garbage collection

* java ee
  - servlets
  - servlet container
  - http handling
  - pooling

### context and dependency injection

- runtime environment

- cdi beans

- cdi services
  - dependency injection
  - interception
  - decoration
  - event handling
  - context management

- cdi is not a full java ee container
- cdi does not manage a Servlet, REST web service (no http, no trxs)
