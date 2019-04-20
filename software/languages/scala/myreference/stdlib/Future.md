# Future (2.10)

- is a way to perform many operations in parallel in an efficient and
  non-blocking (asynchly) way

- scala.concurrent.Future, is container type

- is a placeholder for a result that doesnot yet exist, but which may become
  available at some point

- callbacks are executed eventually

- the order in which callbacks are executed is not deterministic

- is a write-once container, after being completed, it is effectively immutable

- it is read-only placeholder for a result which doesnot yet exist

- Future.sequence converts a Seq[Future[T]] to a Future[Seq[T]]


```scala
object Future {
  def apply[T](body: => T)(implicit executor: ExecutionContext): Future[T]
}

import scala.concurrent.ExecutionContext.Implicits.global

def someFuture[T]: Future[T] = Future {    // using curly braces for method call
  val d = "somedata"
  someComputation()
}

import scala.util.{Success, Failure}
someFuture.onComplete {
  case Success(result)   => println(result)     // future.onSuccess
  case Failure(t) => t.printStrackTrace         // future.onFailure
}
```

*NOTE:* 2.12, onSuccess and on Failure are deprecated. use onComplete or foreach

- T represents the type of the result

- using callbacks can be quite painful if start nesting callbacks
- the real power of Scala Future is that they are composable

```scala
case class Water(temp: Int)
def heatWater(water: Water): Future[Water] = Future {
  println("Heating water now...")
  Thread.sleep(Random.nextInt(2000))
  println("it is hot")
  water.copy(temp = 85)
}

val tempOkay: Future[Boolean] = heatWater(Water(25)).map { water => 
  println("we are in the future")
  (80 to 85).contains(water.temp)
}
```

```scala
import concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
def f(tag: String, ms: Int) = Future {
   println(s"$tag started")
   Thread.sleep(ms)
   println(s"$tag ended")
   tag
}

for {                 // this kind of usage ends in seq execution
  a <- f("a", 500)
  b <- f("b", 300)
  c <- f("c", 200)
} yield a + b + c

val fa = f("a", 500)  // starting parallel execution
val fb = f("b", 300)
val fc = f("c", 200)

for {
   a <- fa
   b <- fb
   c <- fc
} yield a + b + c
```

## Future vs Actor

- Future lets use perform some computation concurrently without needing the
  extra utility of an actor

- The most compelling feature of the Scala Future library is its allows us to
  compose concurrent operations, which is hard to achieve with actors
