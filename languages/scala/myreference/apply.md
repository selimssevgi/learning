# Apply Method

- If a method is called 'apply', you dont have to explicitly call it
- The method apply can be used in classes and objects
- This is a very important concept, it is used extensively in Scala


```scala
class Foo(x:Int) {
    def apply(y:Int) = x + y
}

object Foo {
  def apply(x: Int) = new Foo(x)
}

object MagicRunner extends App {
    val foo = new Foo(10)
    println(foo.apply(20))
    println(foo(20))

    val foo2 = Foo(20) // Foo.apply(20)
}
```

