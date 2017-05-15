# Methods vs Functions

- The common form of a function in Scala is defined as a member of a class
- When a function is defined as a member of a class, it is called a method

```scala
class UseResource {
  def use(r: Resource): Boolean = {}
}
```

- One downside of using methods is that it is easy to depend on the state
  defined by the enclosing class without explicitly passing the dependencies as
  parameters

- Unlike functions, methods dont have any type associated with them


```scala
// Int => Int
val succ = (x: Int) => x + 1

val succFunction = new Function1[Int, Int] {
  def apply(x: Int): Int = x + 1
}
```

- Functions in Scala represented by a type and object, but methods arent

- Methods are only associated with the enclosing class

- Scala lets yoy convert methods to functions using a transform process called
  Eta expansion
