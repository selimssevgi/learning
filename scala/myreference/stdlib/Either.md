# Either

- scala.Either represents one of two possible meaningful results

- Option returns a single meaningful result or Nothing

- Either provides two subclasses: Left and Right

- By convention,
  - Left represents failure
  - Right is akin to Some


```scala
def throwableToLeft[T](block: => T): Either[Throwable, T] = {
  try {
    Right(block)
  } catch {
    case ex Throwable => Left(ex)  
  }
}

val r = throwableToLeft {
  new java.net.Socket("localhost", 4444)  
}

r match {
  case Left(e) => e.printStackTrace
  case Right(e) => println(e)
}
```
