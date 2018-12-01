# Seq

- indexed from 0 to length - 1
- implements PartialFunction, it has an apply method
- it partial cus for all values of Int you may not have elements in the collection

```scala
val languages = Seq("Scala", "Haskell", "OCaml", "ML")

languages(1)
languages(10)     // IndexOutOfBoundsException
```

- two main subclasses of Seq are LinearSeq and Vector
- Vector provides efficient apply and length operations
- LinearSeq has efficient head and tail operations
- two most common subclasses of LinearSeq are List and Stream

- Array, List, Vector, Buffer, and Range

## Array

```scala
val a = Array(1,2,3,4)

val b: Array[String] = Array("selim", "scala")

b(0)  // [] are used for generics
b(0) = 99

val c = Array.fill(100)(0) // Array[Int], size: 100, initialize all with 0
val d = Array.fill(10)(math.random) // using call-by-name so each value is diff

val e - Array.tabulate(10)(i => i*i)
```

## List


```scala
val l = List(1,2,3,4)   // List[Int]
val i = List(1.0,2, 3)  // List[Double]
val s = List(1, "hi")   // List[Any]
val t = List(true, 1)   // List[AnyVal], common parent
```

## Vector

- scala.collection.immutable.Vector
- tree, mutating adds new node

```scala
val v = Vector(1,2,3)
```

## Buffer

- scala.collection.mutable.Buffer

## Range

- 1 to 10
- 1 to 10 by 2
- 10 to 1 by -1

```scala
// Operations on sequences
val xs = List(...)
xs.length         // number of elements, complexity O(n)
xs.last           // last element (exception if xs is empty), complexity O(n)
xs.init           // all elements of xs but the last (exception if xs is empty), complexity O(n)
xs take n         // first n elements of xs
xs drop n         // the rest of the collection after taking n elements
xs(n)             // the nth element of xs, complexity O(n)
xs ++ ys          // concatenation, complexity O(n)
xs.reverse        // reverse the order, complexity O(n)
xs updated(n, x)  // same list than xs, except at index n where it contains x, complexity O(n)
xs indexOf x      // the index of the first element equal to x (-1 otherwise)
xs contains x     // same as xs indexOf x >= 0
xs filter p       // returns a list of the elements that satisfy the predicate p
xs filterNot p    // filter with negated p
xs partition p    // same as (xs filter p, xs filterNot p)
xs takeWhile p    // the longest prefix consisting of elements that satisfy p
xs dropWhile p    // the remainder of the list after any leading element satisfying p have been removed
xs span p         // same as (xs takeWhile p, xs dropWhile p)

List(x1, ..., xn) reduceLeft op    // (...(x1 op x2) op x3) op ...) op xn
List(x1, ..., xn).foldLeft(z)(op)  // (...( z op x1) op x2) op ...) op xn
List(x1, ..., xn) reduceRight op   // x1 op (... (x{n-1} op xn) ...)
List(x1, ..., xn).foldRight(z)(op) // x1 op (... (    xn op  z) ...)

xs exists p    // true if there is at least one element for which predicate p is true
xs forall p    // true if p(x) is true for all elements
xs zip ys      // returns a list of pairs which groups elements with same index together
xs unzip       // opposite of zip: returns a pair of two lists
xs.flatMap f   // applies the function to all elements and concatenates the result
xs.sum         // sum of elements of the numeric collection
xs.product     // product of elements of the numeric collection
xs.max         // maximum of collection
xs.min         // minimum of collection
xs.flatten     // flattens a collection of collection into a single-level collection
xs groupBy f   // returns a map which points to a list of elements
xs distinct    // sequence of distinct entries (removes duplicates)

x +: xs  // creates a new collection with leading element x
xs :+ x  // creates a new collection with trailing element x
```
