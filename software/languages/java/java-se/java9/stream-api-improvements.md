# Stream API Improvements

- takeWhile
- dropWhile
- ofNullable()
- iterate(seed, hasNext, next)

## takeWhile and dropWhile

Haskell              | Java
------------------------------
take(n)              | limit(n)
drop(n)              | skip(n)
takeWhile(Predicate) | takeWhile(Predicate)
dropWhile(Predicate) | dropWhile(Predicate)

## takeWhile

- takes elements until predicates is satisfied, drops afterwards
- correspondens to 'break' in imperative programming

- blue, blue, blue, red, orange, blue
- takeWhile(isBlue): takes only the first 3 blues


## dropWhile

- blue, blue, blue, red, orange, blue
- dropWhile(isBlue): red, orange, blue

```java
// extracting parts with git conflict
Files.lines(Paths.get("resources/index.html")) // file with git conflict
  .dropWhile(l -> !l.containes("<<<<<<<"))
  .skip(1)
  .takeWhile(l -> !l.contains(">>>>>>>"))
  .forEach(System.out::println);
```

## ofNullable

```java
long zero = Stream.ofNullable(null).count()
long one = Stream.ofNullable(getBook()).count()
```

## New Collectors

- filtering(predicate, downstream)

- flatMapping(mapper, downstream)

```java
Map<Set<String>, Set<Book>> bookByAuthors =
  books.collect(
    groupingBy(Book::getAuthors,
               filtering(b -> b.getPrice() > 10, toSet()))
  );

Map<Double, Set<String>> authorsSellingForPrice =
  books.collect(
    groupingBy(Book::getPrice,
               flatMapping(b -> b.getAuthors().stream(), toSet()))
  );
```
