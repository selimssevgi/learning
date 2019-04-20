# Scala Generic Types

- Scala uses square brackets to indicate parameterized types
- Lists (and other generic types) must be parameterized
- There is no equivalent of Java's "raw type" concept


### Tye inference for generic types

```scala
val x = List(1, 2, 3)        // infers x: List[Int]
val y = List("cat", "dog")   // infers y: List[String]
x ::: y // List(1, 2, 3, "cat", "dog") : List[Any]
```

### Caveriance

- Scala does things differently than Java
- Rather than have type variance defined at the point of use of a type, Scala
  allows to make covariance explicit at the point the type is declared.

- Compile time covariance checking
- Any conceptual burden is placed on the writer of a type, not on the users of that type
- Allows intuitive relationships to be built into basic collection types


```java
// List<String> is not subtype of List<Object>
// List<? extends Object> is a subtype of List<Object>
// List[Cat] is a subtype of List[Pet]
```
