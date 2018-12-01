# Optional API Improvements

- ifPresentOrElse(action, emptyAction)

- or(supplier)

- stream(): interoperability between Optional and Stream

- stream.flatMap + Optional.stream

```java
Stream<Optional<Integer>> optionals = Stream.of(
  Optional.of(1),
  Optional.empty(),
  Optional.of(2)
);

Stream<Integer> ints = optionals.flatMap(Optional::stream).forEach(s::out);
```

*  ifPresentOrElse(action, emptyAction)

```java
Optional<Token> token = extractToken(request);

token.ifPresent(System.out::println);

if (token.isPresent()) {
  sout(token.get());
} else {
  sout("nothing here");
}

// a simpler way
token.ifPresentOrElse(s::out, () -> sout("nothing here"));
```

* or(supplier)

```java
getBestOffer()
  .orElse(getExternalOffer().orElse(localFallback.get()));

Optional<Book> bestBook =
  getBestOffer()
    .or(() -> getExternalOffer())
    .or(() -> localFallback);
```
