# Scala Companion Object

- They are also singleton but serve to a class, abstract class or trait
- Companion Objects have the same name as the class they represent
- Companion Objects must be in the same file as the class they represent(companion class)
- Companion Objects have access to their representative class's private information
- Classes have access to the companion object's private information

- Singleton class is referred to as a 'companion object'
- A companion object has a privileged relationship to its class.
- It can access private methods of its class

- Defining a singleton object doesnot define a type.

```scala
class ScreetAgent(val name:String) {
  def shoot(n:Int) {
    SecretAgent.decrementBullets(n)  
  }
}

object SecretAgent {
  private var b:Int = 3000  

  private def decrementBullets(count:Int) {
    if (b - count <= 0)  b = 0
    else b = b - count
  }

  def bullets = b
}

object SecrentAgentRunner extends App {
  val bond = new SecretAgent("James Bond")
  val felix = new SecretAgent("Felix Leitner")

  bond.shoot(800)
  felix.shoot(1000)

  println(SecretAgent.bullets)
}
```


```scala
import java.time._

// protected: just subclass and test class(in the same package)
class Employee protected (val fn:String, val ln:String,
                          val title:String, val hd:LocalDate)

object Employee {
  def create(fn:String, ln:String, title:String) =
      new Employee(fn, ln, title, LocalDate.now)

  def create(fn:String, ln:String, title:String, hd:LocalDate) =
      new Employee(fn, ln, title, hd)
}

object EmployeeDesignRunner extends App {
  val employee = Employee.create("Ken", "Thompson", "Programmer")  
  println(employee.hd)
}
```
