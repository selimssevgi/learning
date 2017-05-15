# Recursion in Scala

- One of the main benefits is that it lets you create solutions without mutation
- Result type must be specified for recursion methods
- Recursive methods have a limited stack space

- imperative, using an mutable variable. BAD!

```scala
var sum = 0
for (e <- List(1, 2, 3)) { sum += e }
```

- a typical way to implement recursive functions is to use pattern matching

```scala
def sum(xs: List[Int]): Int = xs match {
  case Nil => 0
  case x :: ys => x + sum(ys)
}

// remove duplicates
def removeDups(xs: List[Int]): List[Int] = xs match {
  case Nil => Nil
  case x :: ys if (ys.contains(x)) => removeDups(ys)
  case x :: ys => removeDups(ys) :+ x
}
```

- see tail-recursion
