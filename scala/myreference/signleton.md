# Scala Singleton

- 'object' keywords tell compiler to make this class a signleton
- Initial entry points to Scala applications are always contained in an 'object'
- Signleton class is referred to as a 'companion object'
- A companion object has a privileged relationship to its class.
- It can access private methods of its class


```scala
object HelloWorld {
  def main(args : Array[String])  {
    val hello = "Hello World"

    println(hello)
  }
}
```
