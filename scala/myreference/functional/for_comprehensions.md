# For Comprehension

- For comprehension are just map, flatMap, withFilter, and foreach behind the scene
- They look like for loops, but are not, for one they can be assigned to a value
- They return collections like Lists, Sets...
- Any object with map, flatMap, withFilter, foreach can be used inside a for comprehensions
 
```scala
object ForComp extends App {

  for (i <- 1 to 10) {
    println(i)
  }

  val res = for (i <- 1 to 10) yield (i + 1)
  println(res) // Vector(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

  val res2 = (1 to 10).map(_ + 1)
  println(res) // Vector(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

  val res3 = for (i <- List(1,2,3);
                  j <- List(4,5,6)) yield (i, j)
  println(res3) // List((1,4), (1,5), (1,6), (2,4), (2,5), (2,6), (3,4), (3,5), (3,6))

  val res4 = List(1,2,3).flatMap(i => List(4,5,6).map(j => (i, j)))
  println(res4) // List((1,4), (1,5), (1,6), (2,4), (2,5), (2,6), (3,4), (3,5), (3,6))


  val res5 = for (i <- List(1,2,3) if (i % 2) == 0;
                  j <- List(4,5,6)) yield (i, j)
  println(res5) // List((2,4), (2,5), (2,6))

  val res6 = for (i <- List(1,2,3);
                  j <- List(4,5,6)
                  if (j < 6)) yield (i,j)
  println(res6) // List((1,4), (1,5), (2,4), (2,5), (3,4), (3,5))
}
```
