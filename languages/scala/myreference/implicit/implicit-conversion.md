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

```scala
val oneTo10 = 1 to 10

val oneTo20 = 1 --> 20        // error: there is no such method on Int
```

- Create a type that has a --> method defined for the Int type
- Provide an implicit conversion

```scala
class RangeMaker(left: Int) {
  def -->(right: Int) = left to right
}

val range: Range = new RangeMaker(1).-->(20)

implicit def int2RangeMaker(left: Int): Range = new RangeMaker(left)
```

- 1 --> 20
- translated to 1.-->(20)
- there is no method --> method defined in Int class
- scalac looks for an implicit conversion that can convert Int to some type that
  defines --> method

- Compiler will use int2RangeMaker by passing 1 as a parameter
- int2RangeMaker(1).-->(10)
