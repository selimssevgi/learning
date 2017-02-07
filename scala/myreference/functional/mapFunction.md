# Map Function

- Map takes a function and applies that function to every element in a collection
- Map can be applied to Lists, Sets, Maps, Streams, Strings, even Options


```scala
object MapFunction extends App {

  val l = (1 to 5).toList
  println(l)                        // List(1, 2, 3, 4, 5)
  val f = (x:Int) => x + 1
  println(l.map(f))                 // List(2, 3, 4, 5, 6)

  println(l.map((x:Int) => x + 1))  // List(2, 3, 4, 5, 6)
  println(l.map((x) => x + 1))      // List(2, 3, 4, 5, 6)
  println(l.map(_ + 1))             // List(2, 3, 4, 5, 6)
  println(l.map(1 + _))             // List(2, 3, 4, 5, 6)
  println(l.map(1+))                // List(2, 3, 4, 5, 6)

  val b = Set("Brown", "Red", "Blue", "Green")
  println(b.map(x => x.size))     // Set(5, 3, 4), no duplicate
  println(b.map(_.size))          // Set(5, 3, 4), no duplicate

  println(b.map(x => (x, x.size))) // Set((Brown,5), (Red,3), (Blue,4), (Green,5))

  val fifaCamps = Map('Germany -> 4, 'Brazil -> 5, 'Italy -> 4, 'Argentina -> 2)
  println(fifaCamps.map(t => (Symbol.apply("Team " + t._1), t._2)))
  // Map('Team 'Germany -> 4, 'Team 'Brazil -> 5, 'Team 'Italy -> 4, 'Team 'Argentina -> 2)

  println("hello".map(c => (c + 1).toChar)) // ifmmp

}
```
