# Abstract Classes

- A method is abstract if it doesnt have an implementation(no =, or {} )
- abstract modifier is not necessary on Scala methods.

```scala
abstract class Person {
  def firstName:String
  def lastName:String
}

class Employee(val firstName:String, val lastName:String) extends Person
```
