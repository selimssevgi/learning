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

val length = xs.foldLeft(0) { (a, b) => a + 1 }

val sum3 = (0 /: xs)(_+_)        // operator ending ':' is right associative
val sum4 = (xs :\ 0)(_+_)

def factorial(n: Int) = (1 to 5).foldLeft(1)(_*_)
```

```scala
def flatten3[B](xss: List[List[B]]): List[B] = {
  val startValue = List.empty[B]
  xss.foldRight(startValue) { f(_) ::: _ }   // right assosicative
}

def map2[A, B](xs: List[A])(f: A => B): List[B] = {
  val startValue = List.empty[B]
  xs.foldRight(startValue) { f(_) :: _ }     // right assosicative
}

def exists[A](xs: List[A], e: A) =
  xs.foldLeft(false) ((a, x) => a || x == e))
```

## Letter Count

```scala
// val letterCount: Map[Char, Int] = Map()
// s.foldLeft(letterCount)((letter, map) => map + (letter, map.getOrElse(letter, 0) + 1)

val str = "aaabcc"
val emptyLetterCount = Map[Char, Int]()
val letterCount =
  str.foldLeft(emptyLetterCount)((map, letter) => map + (letter -> (map.getOrElse(letter, 0) + 1)))

letterCount.map(e => e._1.toString + e._2.toString).mkString("") // a3b1c2
```

## Word Count

- total word count

```scala
def countWords(fileName: String) = {
  val dataFile = new File(fileName)
  Source.fromFile(dataFile).getLines.foldRight(0) (_.split(" ").size + _)
}
```

- word-count map

```scala
import java.io._

val days = Vector("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday")
val rand = new util.Random()
val file = "/tmp/days.txt"
val content = (1 to 20).map(i => days(rand.nextInt(7))).mkString("\n")
val pw = new PrintWriter(new File(file))
pw.write(content)
pw.close

val words = io.Source.fromFile(file).getLines.flatMap(_.split(" "))
words.foldLeft(Map[String, Int]) { (map, word) =>
  (word -> (map.getOrElse(word, 0) + 1)) }

// collection.immutable.TreeMap for sorted keys
```
