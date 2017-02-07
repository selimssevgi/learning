# Abstract Classes

```scala
abstract class Person {
  def firstName:String
  def lastName:String
}

class Employee(val firstName:String, val lastName:String) extends Person
```
