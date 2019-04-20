# Try

- Error handling with Try (2.10)
- Try represents a computation that may either result in an exception, or
  return a successfully computed value

- Try does for exceptions what Option does for null
- instances of Try[T] are either Success[T], Failure[T]
- only non-fatal exceptions are caught, system errors are thrown
- map, flatMap, recover, recoverWith, filter, getOrElse, toOption
- util.Try


```scala
import util.Try
def div(x: String, y: String): Try[Int] = {
   for {
      a <- Try(x.toInt)
      b <- Try(y.toInt)
   } yield a / b
}

div("a", "0") //Failure(java.lang.NumberFormatException: For input string: "a")
div("1", "b") //Failure(java.lang.NumberFormatException: For input string: "b")
div("1", "0") //Failure(java.lang.ArithmeticException: / by zero)

assert(div("1", "0".toOption == None))
assert(div("1", "0").getOrElse(-1) == -1)
assert(div("42", "9").get == 14)
```

- use Try.get for functions or methods in old code that throws exception
- use Try the it is soppused to, and at the end return Try.get


```scala
val ageStr = "123"

val ageInt = util.Try { ageStr.toInt }  // Success(123)
val ex = util.Try { "abc".toInt }        // Failure(j.l.NFE)

util.Try(age.toInt) match{
    Success(age) => //
    Failure(ex)  => //
}
```

- general-porpuse function to convert from an exception-based API to an Option-oritented

```scala
def Try[A](a: =>A): Option[A] =
  try (Some(a))
  catch { case e: Exception => None }
```
