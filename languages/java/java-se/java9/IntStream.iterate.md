# IntStream

```java
for (int i = 0; i < 10; i = i + 1) {
  sout(i);
}

IntStream.range(0, 10)
  .forEach(sout);

for (int i = 0; i <= 10; i = i + 1) {
  sout(i);
}

IntStream.rangeClosed(0, 10)
  .forEach(sout);
```

```java
for (int i = 0; i < 10; i = i + 3) {
  sout(i);
}

//  (supplier, predicate, function)
for (int i = 0; i < 10; i = i + 3) {

IntStream.iterate(0, i -> i < 10, i -> i + 3)
  .forEach(sout);
```

```java
for (int i = 0; ; i = i + 3) {
  if (i < 10) break;
  sout(i);
}

IntStream.iterate(0, i -> i + 3) // overloaded
  .takeWhile(i -> i < 10)
  .forEach(sout);
```
