# Traits

- Traits are a major part of Scala's approach to OO programming
- Traits play the same rol that interfaces do in Java
- Trait can have implementation of methods(default and static methods in Java interface)


```scala
trait Chipped {
  var chipName : String
  def getName = chipName
}

class Cat(name: String) extends Pet(name: String) with Chipped {
  var chipName = name
}
```
