# Traits

- Traits are a major part of Scala's approach to OO programming
- Traits play the same rol that interfaces do in Java
- Trait can have implementation of methods(default and static methods in Java interface)

- Traits can be used as interface and also as a decorator


```scala
trait Chipped {
  var chipName : String
  def getName = chipName
}

class Cat(name: String) extends Pet(name: String) with Chipped {
  var chipName = name
}
```

## Stackable traits

- with Memoizer with LocaleAware
- with LocaleAware with Memoizer

- super would mean something different in each case
- the interpretation of super in traits is dynamically resolved in Scala

## Trait class files on JVM


```scala
trait Empty {
  def e: Int
}

trait Empty {
  val a = 5
  def e: Int
  def hasBody = println("Hello")
}
```

```java
// scalac Empty.scala
// javap -c Empty
public interface Empty {
  public abstract int e(); }
```
