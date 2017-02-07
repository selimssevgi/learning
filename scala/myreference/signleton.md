# Scala Singleton

- Objects are singletons
- Objects are Scala's replacement for the keyword 'static'
- Initial entry points to Scala applications are always contained in an 'object'

- Object classes cannot be extended
- Object classes can extend(useful?)

- Need a signleton
- Need a factory pattern
- Need to implement pattern matching logic
- Need a utility method that doesnt require an instance or state
- Need default values
- Need a main method


```scala
object HelloWorld {
  def main(args : Array[String])  {
    val hello = "Hello World"

    println(hello)
  }
}
```

```scala
object Runner extends App {
  println("Hello World!")
}
```
