# Right Associative Colon

- If the method ends in a colon, you may invoke it in a right associative way
- In order to invoke in a right associative way, it must be invoked as an infix method
- Right associativity is used primarily with List and Stream operations

```scala
object Runner extends App {
  class Foo(x:Int) {
    def ~:(y:Int) = x + y
  }

  val foo = new Foo(10)
  println(foo.~:(5))
  println(5 ~: foo)  // foo.~:(5)
}
```
