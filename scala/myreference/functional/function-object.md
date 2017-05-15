# Function Object

- is an object that you can use as a function

```scala
object foldl {
  def apply[A, B](xs: Traversable[A], defaultValue: B)(op: (B, A) => B) =
    (defaultValue /: xs)(op)
}

foldl(List("1", "2", "3"), "0") { _ + _ }        // 0123
```

- is a good idea to extend one of the Function traits
- 1 stands for "function with one parameter"
```scala
trait Function1[-T1, +R] extends AnyRef {
  def apply(v: T1): R
}

object ++ extends Function1[Int, Int] {
  def apply(p: Int): Int = p + 1
}

object ++ extends (Int => Int) {
  def apply(p: Int): Int = p + 1
}

val ++ (x: Int) => x + 1 // shorthand
```

- when passing an existing function (not a function object) as a parameter,
  Scala creates a new anonymous function object with an apply method, which
  invokes the original function. This is called "eta-expansion"
