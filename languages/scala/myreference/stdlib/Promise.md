# Promise

- concepts of Promise and Future go hand in hand

- it is an empty container, one place buffer, initially empty, and single
  assignment container: assign once, then just can read

- Promise is the one which sets a value for the Future
- is a writable, single-assignment container which completes a Future

```scala
// minimal
object Promise {
  def apply[T](): Promise[T]
}

trait Promise[T] {
  def success(value: T): this.type
  def failure(cause: Throwable): this.type

  def future: Future[T]
}
```

```scala
val p = Promise[Int]
val f = p.future

assert(!f.isCompleted)
p success 42
assert(f.isCompleted)
```

```scala
import concurrent.Promise

case class TaxCut(reduction: Int)

val taxCut  = Promise[TaxCut]()

val taxCut2: Promise[TaxCut] = Promise()

val taxCutF: Future[TaxCut] =taxCut.future // returns the same Future object every time

taxcut.success(TaxCut(20)) // Promise instance is no longer writable
```
