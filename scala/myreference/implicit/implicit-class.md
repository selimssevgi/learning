# Implicit Classes

- One of common uses of implicit conversion is to add extension methods to existing types

- runtime cost comes from creating an additional instance for each conversion
- can be avoided by turning implicit class into value class

- very powerful but overusing it can reduce the readability and maintenance

```scala
val oneTo10 = 1 to 1

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

## Implicit Classes

- reduce bolilerplace code by combining the steps required for implicit conversion
- must have a primary constructor with one argument

```scala
implicit class RangeMaker(left: Int) {
  def -->(right: Int): Range = left to right
}
```
