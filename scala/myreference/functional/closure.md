# Scala Closures

- Closures are functions that close around the environment
- Closures are used to make up functions from the environment
- It is best to enclose around something that is stable(val)

```scala
class Foo(x:Int) {
  def bar(f:Int => Int) = y(x)
}

object Closures extends App {
  val m = 200
  val f = (x:Int) => x + m  // closing m
  val foo = new Foo(50)
  println(foo.bar(f))   // 250
}
```
