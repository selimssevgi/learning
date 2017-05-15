# Future

- scala.concurrent.Future, is container type

- is an object that hold a value that may become available at a later time

- is a write-once container, after being completed, it is effectively immutable

- it is read-only

- is executed asynchronously

- the simplest way to create a Future by using apply method

- computation to be computated asyncly is passed in as body by-name parameter

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

## Future vs Actor

- Future lets use perform some computation concurrently without needing the
  extra utility of an actor

- The most compelling feature of the Scala Future library is its allows us to
  compose concurrent operations, which is hard to achieve with actors
