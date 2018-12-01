# Implicit Classes (2.10)

- One of common uses of implicit conversion is to add extension methods to existing types
- a more convenient syntax for defining extension methods

- runtime cost comes from creating an additional instance for each conversion
- can be avoided by turning implicit class into value class

- very powerful but overusing it can reduce the readability and maintenance

- implicit classes have a primary constuctor with exactly one parameter

```scala
implicit class A(n:Int) {
   def x = ???
   def y = ???
}
```

- reduce bolilerplace code by combining the steps required for implicit conversion

```scala
implicit class RangeMaker(left: Int) {
  def -->(right: Int): Range = left to right
}
```

- they are desugared into a class and implicit method pairing

```scala
class A(n: Int) { //... }

implicit def A(n:Int) = new A(A)
```

- case clases cannot be implicit, companion object name conflict
