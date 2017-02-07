# Scala Classes

- Classes are public by default
- A class may have auxiliary constructors, denoted using this()
- Auxiliary constructos act like provides of default parameters to the primary constructor
- Class name doesnt have to be same with file name
- Multiple classes in a files is allowed

- val creates accessort, access to the inner state
- var creates mutators, allowing change to inner state
- use javap -p, to see what scala is creating

- equals test for object equality
- Instead of calling equals you can call ==
- 'eq' is used to test if two objects are pointed to the same object


## Uniform Access Principle

- Variables and parameterless methods should be accessed using the same syntax

```scala
class Employee(firstName: String, lastName: String)

val aperson = new Employee("Selim", "Melim")
println(aperson.firstName)  // ERROR

class Employee(val firstName: String, var lastName: String)
// val, creates final field and just getter
// var, creates field, getter and setter

val aperson = new Employee("Selim", "Melim")
println(aperson.firstName)  // public String firstName()
aperson.lastName = "wtf"    // public void lastName_$eq(String)
```

* Java style getter and setters

- @scala.beans.BeanProperty

```scala
class Employee(@BeanProperty val firstName: String, // getFirstName()
               @BeanProperty var lastName:  String) // get/setLastName()
```


## Constructors

- Primary constructors are designed for all information up front
- Ancillary constructors need to find a way to invoke the primary(default values)
- Named argumenets can be used for constructors too
- Default arguments can be used for constructors too(instead of ancillary constructors)

- require checks for quality of parameters in a method or constructor
- require will throw an IllegalArgumentException

```scala
// primary constructor
class Employee(val firstName: String,
               val lastName : String,
               val title    : String) {

    require(firstName.nonEmpty, "First name cannot be empty")

    if (title.contains("Junior")) {
      throw new IllegalArgumentException("Title cannot be Junior")
    }

   // Auxiliary Constructor
   def this(firstName: String, lastName: String)
                 = this(firstName, lastName, "Programmer")

  def changeLastName(ln: String) = new Employee(firstName, ln, title)

  def copy(firstName: String = this.firstName,
           lastName:  String = this.lastName,
           title:     String = this.title)
          = new Employee(firstName, lastName, title)

  override def equals(x: Any): Boolean = {
    if (!(this eq x)) false
    if (!x.isInstanceOf[Employee]) false
    else {
      val other = x.asInstanceOf[Employee]
      // other.firstName.equals(this.firstName) &&
      other.firstName == this.firstName &&         // == is equals()
      other.lastName.equals(this.lastName) &&
      other title.equals(this.title)
    }
  }

  override def hashCode:Int = {
    var result = 19
    result = 31 * this.firstName
    result = 31 * this.lastName
    result = 31 * this.title
    result
  }

  override def toString = {
    s"Employe($firstName, $lastName, $title)"
  }
}
```

## Parameterized Types on Classes


```scala
case class Box[T](t:T)

val intBox = new Box(1)
val intBox2:Box[Int] = new Box(2)

val stringBox = new Box("Box")

val managerBox = Box[Employee](new Manager())

case class Couple[T, U](first:T, second: U)

val coupleIntString = new Couple(3, "Box")
val cis:Couple[Int, String] = new Couple(5, "String")

```

## Parameterized Typed Methods in Classes

- If a type is known at the class level, then it does not need to be declared at
  the method level

```java
case class Box[T](t:T) {
  def coupleWith[U](u:U):Box[Couple[T, U]]  = new Box(new Couple(t, u))
}
```
