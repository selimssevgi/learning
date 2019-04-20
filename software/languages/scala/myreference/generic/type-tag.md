# Type Tags

- type erasure creates some problems at runtime
- type tags are workaround solution of scala

- following piece of code gives error: No ClassTag available for A

```scala
def swapAdjacent[A](arr: Array[A]): Array[A] = {
  import collection.mutable.ArrayBuffer
    val arrBuf = arr.toBuffer
    for (i <- 0 until (arrBuf.length-1) by 2) {
      val temp = arrBuf(i)
        arrBuf(i) = arrBuf(i+1)
        arrBuf(i+1) = temp
    }
  arrBuf.toArray
}
```

- overcome the problem by using ClassTag

```scala
import scala.reflect.ClassTag

def swapAdjacent[A](arr: Array[A])(implicit tag: ClassTag[A]): Array[A] = {
  import collection.mutable.ArrayBuffer
    val arrBuf = arr.toBuffer
    for (i <- 0 until (arrBuf.length-1) by 2) {
      val temp = arrBuf(i)
        arrBuf(i) = arrBuf(i+1)
        arrBuf(i+1) = temp
    }
  arrBuf.toArray
}
```
