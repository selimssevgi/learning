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
