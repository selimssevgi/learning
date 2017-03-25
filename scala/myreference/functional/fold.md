# Fold

- Applies a binary operator to a start value and all elements of the collection


```scala
//TraversableOnce.scala
def /:[B](z: B)(op: (B, A) => B): B = foldLeft(z)(op)
def :\[B](z: B)(op: (A, B) => B): B = foldRight(z)(op)

def foldLeft[B](z: B)(op: (B, A) => B): B = {
  var result = z
  this foreach (x => result = op(result, x))
  result
}

def foldRight[B](z: B)(op: (A, B) => B): B =
  reversed.foldLeft(z)((x, y) => op(y, x))
```

## Examples:

```scala
val xs = List(1, 2, 3, 4)
val sum1 = xs.foldLeft(0)(_+_)
val sum2 = xs.foldLeft(0)((x, y) => x + y)

val sum3 = (0 /: xs)(_+_)        // operator ending ':' is right associative
val sum4 = (xs :\ 0)(_+_)
```

```scala
// val letterCount: Map[Char, Int] = Map()
// s.foldLeft(letterCount)((letter, map) => map + (letter, map.getOrElse(letter, 0) + 1)

val str = "aaabcc"
val emptyLetterCount = Map[Char, Int]()
val letterCount =
  str.foldLeft(emptyLetterCount)((map, letter) => map + (letter -> (map.getOrElse(letter, 0) + 1)))

letterCount.map(e => e._1.toString + e._2.toString).mkString("") // a3b1c2
```

```scala
def factorial(n: Int) = (1 to 5).foldLeft(1)(_*_)
```
