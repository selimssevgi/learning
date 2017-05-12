# Implicits in Scala

- There is a fundamental difference between your code and libs of other people:
  1. You can change or extend your own code
  2. If you want to use some other libs, you have to take them as they are

- Smalltalk has meta classes, Ruby has modules. They are powerful but dangerous.
- Modifying the behavior of a class for an entire application may be dangerous.
- C# has method extensions, which are more local but more restrictive.

- Scala has implicit parameters and conversions.
- Implicits can make existing libraries much more pleasant to deal with.

```scala
val x = new Array[Int](5)
val v: String = x
```

- Array[Int] does not conform to String, so normally this would give a type error.
- However, you can define a conversion function from array to String:

```scala
implicit def array2string[T](x: Array[T]) = x.toString
```

- If such an implicit conversion is visible at the point of an otherwise illegal
  assignment, the conversion is automatically inserted.

```scala
val v: String = array2string(x)
```

- Implicit conversions can be applied in other situations.
- For ex: when selecting a member of some value which is undefined in its type.

- 'append' operator on arrays:

```scala
val x = Array(1, 2, 3)
val y = Array(4, 5, 6)
val z = x append y
```

- Scala's arrays are directly mapped to Java's arrays.
- There is no 'append' method in either type.
- Implicit conversions can help:

```scala
class RichArray[T](value: Array[T]) {
  def append(other: Array[T]): Array[T] = {
    val result = new Array(value.length + other.length)
    Array.copy(value, 0, result, 0, value.length)
    Array.copy(other, 0, result, value.length, other.length)
    result
  }
}
```

- An implicit conversion from plain arrays to rich arrays:

```scala
implicit def enrichArray[T](xs: Array[T]) = new RichArray[T]
```

- With this conversion, we have effectively enrich Java's array class with an
  'append' method.
