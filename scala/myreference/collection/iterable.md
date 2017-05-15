# Iterable

- It comes after Traversable
- provides the implementation of foreach

- most interesting thing about Iterable trait is its three base classes:
  - Seq
  - Set
  - Map


```scala
Iterable(1, 2, 3, 4, 5) dropRight 2          // 1, 2, 3
Iterable(1, 2, 3, 4, 5) takeRight 2          // 4, 5
```

