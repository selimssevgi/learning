# Pattern Matching

- Simple cases of 'match' are related to Java's switch, but more expressive
- Scala calls the different types of case clauses 'patterns'
- break is implicit. No fall-through errors.

- contant pattern
- variable pattern
- wildcard pattern
- constructor pattern
- sequence pattern
- tuple pattern
- typed pattern

- guarded pattern


```scala
def listLength(xs: List[Int]):Int = xs match {
  case Nil   => 0
  case x::xs => 1 + listLength(xs)
}
```

```scala
list.find(_>2) match {
  case None    => "Not found"
  case Some(i) => "Found " + i
}
```

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

- Bounded variable in match

```scala
val a = 5
val b = 20 // it has to be val

val res = a*4 match {
  case 0 => "zero"
  case 1 => "one"
  case `b` => "same as b" // matching with another variable value
  case i => "something bigger," + i // i is like a default, bounded  to a*4
}
```

```scala
val firstArg = if (args.length > 0) args(0) else ""

firstArg match {
  case "salt"  => println("pepper")
  case "chips" => println("salsa")
  case "eggs"  => println("bacon")
  case _       => println("huh?")
}

// match result in value
val friend =
  firstArg match {
    case "salt"  => "pepper"
    case "chips" => "salsa"
    case "eggs"  => "bacon"
    case _       => "huh?"
  }

println(friend)
```

* Typed Pattern

```scala
def storageSize(obj: Any) = obj match {
  case s: String => s.length
  case i: Int    => 4
  case _         => -1
}


def printType(obj: AnyRef) = obj match {
  case s: String => println("This is a string")
  case l: List[_] => println("This is a List")
  case a: Array[_] => println("This is an array")
  case d: java.util.Date => println("This is a date")
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

* Guarded Pattern Matching

```scala
def rangeMatcher(num: Int) = num match {
 case within10  if within10  <= 10 => println("with in 0 to 10")
 case within100 if within100 <= 100 => println("with in 11 to 100")
 case beyond100 if beyond100 <= Integer.MAX_VALUE => println("beyond 100")
}
```

## Power of Pattern Matching

```scala
def createErrorMessage(errorCode: Int) : String = {
  var result : String = _  // initialized to default
  errorCode match {
    case 1 =>
      result = "Network Failure"
    case 2 =>
      result = "I/O Failure"
    case _ =>
      result = "Unknown Error"
  }
  return result;
}
```

```scala
def createErrorMessage(errorCode: Int) : String = {
  val result = errorCode match {
    case 1 => "Network Failure"
    case 2 => "I/O Failure"
    case _ => "Unknown Error"
  }

  return result
}
```

```scala
def createErrorMessage(errorCode: Int) : String = errorCode match {
  case 1 => "Network Failure"
  case 2 => "I/O Failure"
  case _ => "Unknown Error"
}
```
