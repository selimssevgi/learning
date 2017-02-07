# zip Function

- Zip intertwines two collections
- Zip result will be the size of the shorter collection

```scala
object Zip extends App {

  val a = List(1,2,3)
  val b = List(4,5,6)
  println(a zip b) // List((1,4), (2,5), (3,6))

  println((1 to 5) zip (6 to 9))
  // Vector((1,6), (2,7), (3,8), (4,9))
  println((1 to 2) zip (6 to 9))
  // Vector((1,6), (2,7))
}
```
