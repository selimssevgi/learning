# Tail-Recursion

- Recursive funtions may run out of stack memory
- Tails recursive functions after evaluation must be returned
- @scala.annotation.tailrec can be used for assistance

```scala
def length[A](xs: List[A]): Int = xs match {
  case Nil => 0
  case x :: ys => 1 + length(ys)
}
```

- Using length functions with a list containing 100,000 elements or so you will
  get a StackOverflowError

```scala
def legnth2[A](xs: List[A]): Int = xs match {
  def _length2[A](xs: List[A], len: Int) = xs match {
    case Nil => 0
    case x :: ys => _length2(ys, 1 + len)
  }
  _length2(xs, 0)
}
```

- in the above code there is no any calculation after the recursive call
- Scala does tail call optimization at compile time
- the compiler transforms a tail recursive function into a loop
- Scala cant optimize every tail recursion, not nonfinal methods
- the best way to know whether compiler can optimize tail recursion is to use
  @tailrec annotation

```scala
import scala.annotation.tailrec

def legnth2[A](xs: List[A]): Int = xs match {
  @tailrec
  def _length2[A](xs: List[A], len: Int) = xs match {
    case Nil => 0
    case x :: ys => _length2(ys, 1 + len)
  }
  _length2(xs, 0)
}
```
