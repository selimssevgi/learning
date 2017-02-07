# Ranges

- Ranges are a way to create a collection of numbers or characters without
  specifying them one by one

- Treat ranges with the same methods as you would a List
- You can create ranges with syntax sugar
- You can create ranges with a factory in the Range companion object


```scala
val r = 1 to 3    // Range(1, 2, 3)
val t = 1 until 3 // Range(1, 2)

val x = 1 to 10 by 2    // Range(1, 3, 5, 7, 9)
val y = 10 to 0 by -3   // Range(10, 7, 4, 1)

val z = ('a' to 'z') ++ ('A' to 'Z')

val a = Range(1, 10) // exclusive
val b = Range(1, 10, 2)

val c = Range.inclusive(1, 10)

val d = Range.inclusve(1, 10, 2)

```
