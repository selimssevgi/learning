# qualifier

- instead of string or xml configuration, uses annotation qualifier for type-safety

```java
public class BookService {
  @Inject
  private NumberGenerator generator;
}

// @Default
public class IsbnGenerator implement NumberGenerator {}
```

- we have a single implementation for the injection point, works as fine

* @Default is the default qualifier annotation

```java
public class BookService {
  @Inject
  private NumberGenerator generator;
}

@Default
public class IsbnGenerator implement NumberGenerator {}

@Default
public class IssnGenerator implement NumberGenerator {}
```

- ambiguity because now we have two condidates for the injection point

```java
public class BookService {
  @Inject
  @EightDigits // can swap the qualifier
  private NumberGenerator generator;
}

@ThirteenDigits
public class IsbnGenerator implement NumberGenerator {}

@EightDigits
public class IssnGenerator implement NumberGenerator {}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD, PARAMETER})
public @interface EightDigits {}
```

### qualifiers with members

```java
@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD, PARAMETER})
public @interface Generator {
  NumberOfDigits numberOfDigits();

  boolen printed();

  public enum NumberOfDigits { EIGHT, THIRTEEN }
}

@Generator(numberofdigits = THIRTEEN, printed = false)
public class IssnGenerator implement NumberGenerator {}

@Generator(numberofdigits = EIGHT, printed = true)
public class IssnGenerator implement NumberGenerator {}
```
