# Scala Singleton

- One way in which Scala is more OO than Java is that classes in Scala cannot
  have static members. Instead Scala has 'singleton objects'.

- Objects are singletons
- Objects are Scala's replacement for the keyword 'static'
- Initial entry points to Scala applications are always contained in an 'object'

- One difference between classes and singleton objects is that singleton object
  cannot take parameters, whereas classes can.

- Object classes cannot be extended
- Object classes can extend(useful?)

- Need a signleton
- Need a factory pattern
- Need to implement pattern matching logic
- Need a utility method that doesnt require an instance or state
- Need default values
- Need a main method

- When a singleton object shares the same name with a class, it is called that
  class's *companion object*.

- A singleton object that doesnot share the same name with a companion class is
  called *standalone object*.


```scala
object HelloWorld {
  def main(args : Array[String]) {
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
