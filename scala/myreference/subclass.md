# SubClasses

- override keyword is mandatory

```scala
class Department(val name: String)

class Manager(fn: String, ln: String, title: String, department: Deparmnet)
      extends Employee(fn:String, ln:String, title:String) {


  override def fullName = s"$firstName $lastName, ${department.name} Manager"
}
```
