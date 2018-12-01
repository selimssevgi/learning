# flatMap Function

- FlatMap for collections is the combination of flatten and map
- Your cue to use flatMap is when you see List[List[A]]

```scala
// recursive, stackoverflow on big data set
def flatten[B](xss: List[List[B]]): List[B] = {
  xss match {
    case List() => Nil
    case head :: tail => head ::: flatten(tail)
  }
}

// tail recursive
def flatten2[B](xss: List[List[B]]): List[B] = {
  def _flatten2[B](xss: List[List[B]], newList: List[B]): List[B] = {
    xss match {
      case List() => newList
      case head :: tail => _flatten2(tail, newList ::: head)
    } 
  }
  _flatten2(xss, Nil);
}

def flatten3[B](xss: List[List[B]]): List[B] = {
  val startValue = List.empty[B]
  xss.foldRight(startValue) { f(_) ::: _ }
}

def flatMap[A, B](xs: List[A])(f: A => List[B]): List[B] = {
  flatten(map(xs, f))
}
```

```scala
List("one", "two") flatMap { _.toList }
// List[Char] = List('o', 'n', 'e', 't', 'w', 'o')

List("one", "two") map { _.toList }
// List[List[Char]] = List(List('o', 'n', 'e'), List('t', 'w', 'o'))
```

```scala
val a = List(1,2,3)
a.map(x => List(-x, 0, x))
a.map(x => List(-x, 0, x)).flatten
a.flatMap(x => List(-x, 0, x))
// List(-1, 0, 1, -2, 0, 2, -3, 0, 3)

Set(2, 4, 10, 11).flatMap(x => Set(x, x * 5)))
// Set(10, 20, 2, 50, 11, 55, 4)

val map = Map(1 -> "One", 2 -> "Two")
map.flatMap(t => Map(t._1 -> t._2, (t._1 * 100) -> (t._2 + "Hundred")))
// Map(1 -> One, 100 -> OneHundred, 2 -> Two, 200 -> TwoHundred)
```
