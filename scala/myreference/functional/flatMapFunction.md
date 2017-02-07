# flatMap Function

- FlatMap for collections is the combination of flatten and map
- Your cue to use flatMap is when you see List[List[A]]

```scala
object FlatMaps extends App {

  val a = List(1,2,3)
  println(a.map(x => List(-x, 0, x)))
  println(a.map(x => List(-x, 0, x)).flatten)
  println(a.flatMap(x => List(-x, 0, x)))
  // List(-1, 0, 1, -2, 0, 2, -3, 0, 3)

  println(Set(2,4,10, 11).flatMap(x => Set(x, x * 5)))
  // Set(10, 20, 2, 50, 11, 55, 4)

  val map = Map(1 -> "One", 2 -> "Two")

  println(map.flatMap(t => Map(t._1 -> t._2,
                               (t._1 * 100) -> (t._2 + "Hundred"))))
  // Map(1 -> One, 100 -> OneHundred, 2 -> Two, 200 -> TwoHundred)

}
```
