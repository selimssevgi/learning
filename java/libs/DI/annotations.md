# JSR-330 Annotations

- javax.inject, a single Provider interface
- @Inject
- @Qualifier
- @Named
- @Scope
- @Singleton

## @Inject Annotation

- where can be defined and order that they're processed.
  1. Constructors
  2. Methods
  3. Fields

- One constructor with @Inject annotation is allowed, JRE woulnt know the precedence.
- For mandatory parameters use constructor, for optional parameters use setter injection.
- Injecting to non-final fields is possible but not a good practise for testibility.

## @Qualifier Annotation

- Two objects of same type configured in IoC container, to distinguish between
  those two objects when it came to injecting them into code.


```java
@Documented
@Retention(RUNTIME)
@Qualifier
public @interface MusicGenre {
  Genre genre() default Genre.TRANCE;
  www.it-ebooks.infoStandardized DI in Java
  public enum GENRE { CLASSICAL, METAL, ROCK, TRANCE }
}

// @MusicGenre(GENRE.METAL)
```

## @Named Annotation

- Is a specific @Qualifier that provides a contract for implementations to
  qualify injected objects by their names.

```java
public class MurmurMessenger {
  @Inject @Named("murmur")
  private MurmurMessage murmurMessage;

  @Inject @Named("broadcast")
  private MurmurMessage broadcastMessage;
}
```

## @Scope Annotation

- Defines a contract that can be used to define how the injector(IoC container)
  reuses instances of the injected object.

## @Singleton Annotation

- to inject a value that doesnot change
- If a scope is not declared, most DI framework assumes @Singleton as default.
