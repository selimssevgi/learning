# Match Expressions

- Simple cases of 'match' are related to Java's switch, but more expressive
- Scala calls the different types of case clauses 'patterns'



```scala
val turkishDayOfWeek = args(0) match {
  case "Sunday"    => "Pazar"
  case "Monday"    => "Pazartesi"
  case "Tuesday"   => "Sali"
  case "Wednesday" => "Carsamba"
  case "Thurday"   => "Persembe"
  case "Friday"    => "Cuma"
  case "Cumartesi" => "Cumartesi"
  case _           => "Error: '" + args(0) + "' is no a day of week"
}

println(turkishDayOfWeek)
```

* Typed Pattern

```scala
def storageSize(obj: Any) = obj match {
  case s: String => s.length
  case i: Int    => 4
  case _         => -1
}
```

* Exception Handling

```scala
catch {
  case e: ClassNotFoundException => {
    val msg = "Can't load reporter class"
    val iae = new IllegalArgumentException(msg)
    iae.initCause(e)
    throw iae
  }
  case e: InstantiationException => {
    val msg = "Can't instantiate Reporter"
    val iae = new IllegalArgumentException(msg)
    iae.initCause(e)
    throw iae
  }
}
```
