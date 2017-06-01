# Buffers

- buffers are always mutable
- most collections are are internally built using buffers
- two common subclasses of Buffer are mutable.ListBuffer and mutable.ArrayBuffer


```scala
import scala.collection.mutable.ListBuffer

val buf = ListBuffer(1, 2, 3, 4, 5)

buf(2)  // 3

buf.update(2, 20)   // [2] = 20
```

## Array Buffer

- variable-length arrays
- ArrayList in Java, Vector in C++

```scala
import scala.collection.mutable.ArrayBuffer
val b = ArrayBuffer[Int]()

b += 1

b += (1,2,3)  // add multiple elements

b ++= ArrayBuffer(1,2,3)  // append any collection

b.trimEnd(5) // removes last five elements b
```
