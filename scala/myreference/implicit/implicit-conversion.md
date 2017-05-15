# Implicit Conversion

- Implicit conversion is a method that takes one type of parameter and returns another type

- can take time, but it is not much of an issue cus it happens at compile time

* Explicit conversion

```scala
val someInt: Int = 2.3                  // type mismatch

def double2Int(d: Double): Int = d.toInt

val someInt: Int = double2Int(2.3)
```

* Implicit conversion: compiler finds the appropriate implicit conversion

```scala
implicit def double2Int(d: Double): Int = d.toInt

val someInt: Int = 2.3
```

- When the compiler encounters a type error, it doesnt immediately give up
- instead, it looks for any implicit conversions that might fix the error

- Compiler throws an error when there is no appropriate conversion method
- Compiler also throws an error if there is ambiguaity in an implicit resolution
