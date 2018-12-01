# Streams

- non-strict / lazy collection


```scala
val ones: Stream[Int] = Stream.cons(1, ones) // recursive value definition

ones take 5 toList

ones exists { _ % 2 != 0 }  // true, enough if it has only one match

ones map { _ + 1 } exists { _ % 2 == 0 } // true, one element at the time, goes throught all piped functions

ones takeWhile { _ == 1 } // another stream

ones forall { _ != 1 }  // false, one enough to prove otherwise

ones forall { _ == 1 }  // stackoverflow, took so long, can be infinite loop
```
